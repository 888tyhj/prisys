package com.prisys.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.bean.Tree;
import com.prisys.web.dao.OrganizationDao;
import com.prisys.web.entity.Organization;
import com.prisys.web.service.OrganizationService;

/**
 * <p>User: yangl
 * <p>Date: 14-2-14
 * <p>Version: 1.0
 */
@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    private OrganizationDao organizationDao;

    @ServiceLog("新增组织")
    public String createOrganization(Organization organization) {
    	boolean isName=this.isExists(" and name='"+organization.getName()+"' ");
    	String str="录入成功";
    	if(isName){
    		str="1";//存在名称
    	}else{
    		boolean isCode=this.isExists(" and code='"+organization.getCode()+"' ");
    		if(isCode){
    			str="2";//存在名称
        	}else{
        		organizationDao.insert(organization);
        	}
    	}
        return str;
    }

    @ServiceLog("更新组织")
    public String updateOrganization(Organization organization) {
        boolean isName=this.isExists(" and id!="+organization.getId()+" and name='"+organization.getName()+"' ");
     	String str="修改成功";
     	if(isName){
     		str="1";//存在名称
     	}else{
     		boolean isCode=this.isExists(" and id!="+organization.getId()+" and code='"+organization.getCode()+"' ");
     		if(isCode){
     			str="2";//存在名称
         	}else{
         		organizationDao.updateByPrimaryKey(organization);
         	}
     	}
         return str;
    }
    
    public boolean isExists(String param){
    	List<Organization> list=organizationDao.selectByParam(param);
    	boolean flag=false;
    	if(list.size() > 0){
    		flag=true;
    	}
    	return flag;
    }

    @ServiceLog("删除组织")
    public void deleteOrganization(Long organizationId) {
    	Organization o=this.findOne(organizationId);
        organizationDao.deleteFromParentIdsById(o);
        organizationDao.deleteFromParentIdsById(o.getParentIds()+organizationId+"/");
    }

    
    public Organization findOne(Long organizationId) {
        return organizationDao.selectByPrimaryKey(organizationId);
    }

    
    public List<Organization> findAll() {
        return organizationDao.selectAll();
    }

    
    public List<Organization> findAllWithExclude(Organization excludeOraganization) {
        return organizationDao.selectAllWithExclude(excludeOraganization);
    }

    
    public void move(Organization source, Organization target) {
        organizationDao.moveByPrimaryKey(target.getId(), target.makeSelfAsParentIds(), source.getId());
        organizationDao.moveSourceDescendants(target.makeSelfAsParentIds(), source.makeSelfAsParentIds());
    }
    
    @Override
    public List<Tree> ajaxOrganizationTree() {
		List<Tree> list = new ArrayList<Tree>();
        List<Tree> treeList = new ArrayList<Tree>();
        List<Organization> listRoot = organizationDao.selectAllByParentId(0l);
        for (Organization t : listRoot) {
            Tree tree = new Tree();
            tree.setId(t.getCode());
            tree.setText(t.getName());
            Map<String, Object> map = new HashMap<String, Object>();
         	map.put("id", t.getId());
     		tree.setAttributes(map);
//            tree.setIconCls("icon-envelope-alt");
            tree.setChildren(this.findChildTree(t.getId()));
            treeList.add(tree);
        }
        Tree root = new Tree();
        root.setText("根目录");
        root.setChildren(treeList);
        root.setState("open");
        list.add(root);
        return list;
	}
    /**
     * @Title: findChildTree
     * @Description: 递归获取树形
     * @author yangl  
     * @param parentId 父id
     * @param name 文档名称
     * @return List<Tree> 返回属性集合
      */
 	public List<Tree> findChildTree(Long parentId){
 		List<Organization>  chiList = organizationDao.selectAllByParentId(parentId);
 		List<Tree> chilList = new ArrayList<Tree>();
         for (Organization tt : chiList) {
         	Tree chi = new Tree();
         	chi.setId(tt.getCode());
         	chi.setText(tt.getName());
         	Map<String, Object> map = new HashMap<String, Object>();
//     		map.put("type", tt.getType());
//     		map.put("url", tt.getWordUrl());
//     		map.put("fileNewName", tt.getFileNewName());
//     		map.put("sztb", tt);
         	map.put("id", tt.getId());
     		chi.setAttributes(map);
         	chi.setChildren(findChildTree(tt.getId()));
            chilList.add(chi);
         }
         return chilList;
 	}


	@Override
	public Organization findOne(String organizationId) {
		List<Organization> organizationList=organizationDao.selectByParam(" and code='"+organizationId+"' ");
		Organization organization=null;
    	if(organizationList != null && organizationList.size() > 0){
    		organization=organizationList.get(0);
    	}
        return organization;
	}
	
	public Map<String,Object> selectByParam(String param){
		Map<String,Object> map=new HashMap<String,Object>();
    	List<Organization> list=organizationDao.selectByParam(param);
		map.put("rows", list);
    	map.put("total", list.size());
    	return map;
	}
}
