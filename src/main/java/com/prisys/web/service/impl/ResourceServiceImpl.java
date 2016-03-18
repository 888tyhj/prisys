package com.prisys.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.bean.Tree;
import com.prisys.web.dao.ResourceDao;
import com.prisys.web.entity.Resource;
import com.prisys.web.service.ResourceService;

/**
 * <p>User: 杨磊
 * <p>Date: 15-2-14
 * <p>Version: 1.0
 */
@Service
public class ResourceServiceImpl implements ResourceService {

	@javax.annotation.Resource
    private ResourceDao resourceDao;

	@ServiceLog("新增菜单")
    public String createResource(Resource resource) {
        boolean isName=this.isExists(" and name='"+resource.getName()+"' ");
    	String str="录入成功";
    	if(isName){
    		str="1";//存在名称
    	}else{
        	resourceDao.insert(resource);
    	}
        return str;
    }

	@ServiceLog("修改菜单")
    public String updateResource(Resource resource) {
        boolean isName=this.isExists(" and id !="+resource.getId()+" and name='"+resource.getName()+"' ");
     	String str="修改成功";
     	if(isName){
     		str="1";//存在名称
     	}else{
     		resourceDao.updateByPrimaryKey(resource);
     	}
         return str;
    }

	public boolean isExists(String param){
    	List<Resource> list=resourceDao.selectByParam(param);
    	boolean flag=false;
    	if(list.size() > 0){
    		flag=true;
    	}
    	return flag;
    }
	
    @ServiceLog("删除菜单")
    public void deleteResource(Long resourceId) {
    	Resource r=this.findOne(resourceId);
        resourceDao.deleteResource(r);
        String ids=r.getParentIds()+resourceId+ "/";
        resourceDao.deleteByIdAndParentIds(ids);
    }

    
    public Resource findOne(Long resourceId) {
        return resourceDao.selectByPrimaryKey(resourceId);
    }

    
    public List<Resource> findAll() {
        return resourceDao.selectAll();
    }

    
    public Set<String> findPermissions(Set<Long> resourceIds) {
        Set<String> permissions = new HashSet<String>();
        for(Long resourceId : resourceIds) {
            Resource resource = findOne(resourceId);
            if(resource != null && !StringUtils.isEmpty(resource.getPermission())) {
                permissions.add(resource.getPermission());
            }
        }
        return permissions;
    }

    
    public List<Resource> findMenus(Set<String> permissions) {
        List<Resource> allResources = findAll();
        List<Resource> menus = new ArrayList<Resource>();
        for(Resource resource : allResources) {
            if(resource.isRootNode()) {
                continue;
            }
            if(!resource.getType().equals("menu") ) {
                continue;
            }
            if(!hasPermission(permissions, resource)) {
                continue;
            }
            menus.add(resource);
        }
        return menus;
    }

    private boolean hasPermission(Set<String> permissions, Resource resource) {
        if(StringUtils.isEmpty(resource.getPermission())) {
            return true;
        }
        for(String permission : permissions) {
            WildcardPermission p1 = new WildcardPermission(permission);
            WildcardPermission p2 = new WildcardPermission(resource.getPermission());
            if(p1.implies(p2) || p2.implies(p1)) {
                return true;
            }
        }
        return false;
    }
    
    public Map<String,Object> queryResourceByParam(String param, Integer page, Integer rows){
    	Map<String,Object> map=new HashMap<String,Object>();
    	List<Resource> list=resourceDao.queryResourceByParam(param, page, rows);
		map.put("rows", list);
    	map.put("total", list.size());
    	return map;
    }
    
    @Override
    public List<Tree> ajaxResourceTree() {
		List<Tree> list = new ArrayList<Tree>();
        List<Tree> treeList = new ArrayList<Tree>();
        List<Resource> listRoot = resourceDao.selectAllByParentId(0l);
        for (Resource t : listRoot) {
            Tree tree = new Tree();
            tree.setId(t.getId()+"");
            tree.setText(t.getName());
            tree.setIconCls("icon-list");
            tree.setChildren(this.findChildTree(t.getId()));
            treeList.add(tree);
        }
        Tree root = new Tree();
        root.setText("根目录");
        root.setChildren(treeList);
        //root.setIconCls("icon-home");
        root.setState("open");
        list.add(root);
        return list;
	}
    /**
     * @Title: findChildTree
     * @Description: 递归获取树形
     * @author yangl  
     * @param parentId 父id
     * @return List<Tree> 返回属性集合
      */
 	public List<Tree> findChildTree(Long parentId){
 		List<Resource>  chiList = resourceDao.selectAllByParentId(parentId);
 		List<Tree> chilList = new ArrayList<Tree>();
         for (Resource tt : chiList) {
         	Tree chi = new Tree();
         	chi.setId(tt.getId()+"");
         	chi.setText(tt.getName());
         	if(tt.getType().equals("menu")){
         		chi.setIconCls("icon-list");
         	}else{
         		chi.setIconCls("icon-tags");
         	}
         	chi.setChildren(findChildTree(tt.getId()));
            chilList.add(chi);
         }
         return chilList;
 	}
 	/**
 	 * 菜单显示
 	 */
    public List<Tree> findMenuResourceTree(String username) {
        List<Tree> treeList = new ArrayList<Tree>();
        List<Resource> listRoot = resourceDao.selectAllByParentId(1l, username);
        for (Resource t : listRoot) {
        		Tree tree = new Tree();
                tree.setId(t.getId()+"");
                tree.setText(t.getName());
                Map<String, Object> map = new HashMap<String, Object>();
             	map.put("url", t.getUrl());
         		tree.setAttributes(map);
                tree.setChildren(this.findMenuChildResourceTree(t.getId(), username));
                treeList.add(tree);
        }
        return treeList;
	}
    /**
     * @Title: findChildResourceTree
     * @Description: 递归获取树形(菜单显示)
     * @author yangl  
     * @param parentId 父id
     * @return List<Tree> 返回属性集合
      */
 	public List<Tree> findMenuChildResourceTree(Long parentId, String username){
 		List<Resource>  chiList = resourceDao.selectAllByParentId(parentId, username);
 		List<Tree> chilList = new ArrayList<Tree>();
         for (Resource tt : chiList) {
         	Tree chi = new Tree();
         	chi.setId(tt.getId()+"");
         	chi.setText(tt.getName());
         	if(tt.getType().equals("menu")){
         		chi.setChildren(findChildTree(tt.getId()));
         	}
         	Map<String, Object> map = new HashMap<String, Object>();
         	map.put("url", tt.getUrl());
     		chi.setAttributes(map);
            chilList.add(chi);
         }
         return chilList;
 	}
}
