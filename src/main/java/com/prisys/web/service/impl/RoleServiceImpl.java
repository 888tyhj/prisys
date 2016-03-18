package com.prisys.web.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.dao.RoleDao;
import com.prisys.web.entity.Resource;
import com.prisys.web.entity.Role;
import com.prisys.web.entity.RoleRes;
import com.prisys.web.service.ResourceService;
import com.prisys.web.service.RoleResService;
import com.prisys.web.service.RoleService;

/**
 * 
* @ClassName: RoleServiceImpl
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:32:21
*
 */
@Service
public class RoleServiceImpl implements RoleService {

	@javax.annotation.Resource
    private RoleDao roleDao;
	@javax.annotation.Resource
    private ResourceService resourceService;
	@javax.annotation.Resource
	private RoleResService roleResService;

	@ServiceLog("新增角色")
    public String createRole(Role role) {
        boolean isName=this.isExists(" and name='"+role.getName()+"' ");
    	String str="录入成功";
    	if(isName){
    		str="1";//存在名称
    	}else{
    		boolean isCode=this.isExists(" and role='"+role.getRole()+"' ");
    		if(isCode){
    			str="2";//存在code
        	}else{
        		roleDao.insert(role);
        	}
    	}
        return str;
    }

	@ServiceLog("更新角色")
    public String updateRole(Role role) {
         boolean isName=this.isExists(" and id != "+role.getId()+" and name='"+role.getName()+"' ");
     	String str="修改成功";
     	if(isName){
     		str="1";//存在名称
     	}else{
     		boolean isCode=this.isExists(" and id != "+role.getId()+" and role='"+role.getRole()+"' ");
     		if(isCode){
     			str="2";//存在code
         	}else{
         		roleDao.updateByPrimaryKey(role);
         	}
     	}
         return str;
    }
	
	public boolean isExists(String param){
    	List<Role> list=roleDao.selectByParam(param);
    	boolean flag=false;
    	if(list.size() > 0){
    		flag=true;
    	}
    	return flag;
    }

	@ServiceLog("删除角色")
    public void deleteRole(Long roleId) {
        roleDao.deleteByPrimaryKey(roleId);
    }

    
    public Role findOne(Long roleId) {
        return roleDao.selectByPrimaryKey(roleId);
    }
    
    public Role findOne(String code) {
    	List<Role> roleList=roleDao.selectByParam(" and role='"+code+"' ");
    	Role role=null;
    	if(roleList != null && roleList.size() > 0){
    		role=roleList.get(0);
    	}
        return role;
    }

    
    public List<Role> findAll() {
        return roleDao.selectAll();
    }

    
    public Set<String> findRoles(String... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(String roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    
    public Set<String> findPermissions(String[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(String roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                resourceIds.addAll(this.getListResourceIds(role.getId()));
            }
        }
        return resourceService.findPermissions(resourceIds);
    }
    /**获取菜单id*/
    public List<Long> getListResourceIds(Long roleId){
    	 List<Long> list=new ArrayList<Long>();
    	 List<RoleRes> roleResList=roleResService.queryRoleResListByRoleId(roleId);
    	 for(RoleRes r:roleResList){
    		 list.add(r.getResID());
    	 }
	     return list;
    }

    @Override
	public List<Resource> findResourceList(String[] roleIds) {
    	List<Resource> list = new ArrayList<Resource>();
        for(String roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
            	list.addAll(this.getListResource(role.getId()));
            }
        }
		return list;
	}
    
    /**获取菜单List*/
    public List<Resource> getListResource(Long roleId){
    	 List<Resource> list=new ArrayList<Resource>();
    	 List<RoleRes> roleResList=roleResService.queryRoleResListByRoleId(roleId);
    	 for(RoleRes r:roleResList){
    		 Resource rr=resourceService.findOne(r.getResID());
    		 if(rr.getType().equals("menu")){
    			 list.add(rr);
    		 }
    	 }
	     return list;
    }
    
	@Override
	public List<Role> queryRoleByParam(String param, Integer page, Integer rows) {
		return roleDao.queryRoleByParam(param, page, rows);
	}

	@Override
	public Long queryRoleTotalByParam(String param) {
		return roleDao.queryRoleTotalByParam(param);
	}

}
