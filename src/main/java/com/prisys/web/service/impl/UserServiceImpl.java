package com.prisys.web.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.dao.UserDao;
import com.prisys.web.entity.Organization;
import com.prisys.web.entity.Role;
import com.prisys.web.entity.User;
import com.prisys.web.service.OrganizationService;
import com.prisys.web.service.RoleService;
import com.prisys.web.service.UserService;
import com.prisys.web.utils.PasswordHelper;

/**
 * 
* @ClassName: UserServiceImpl
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:32:28
*
 */
@SuppressWarnings("all")
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Resource
    private PasswordHelper passwordHelper;
    @Resource
    private RoleService roleService;
    
    @Resource
    private OrganizationService organizationService;

    /**
     * 创建用户
     * @param user
     */
    @ServiceLog(value="创建用户")
    public String createUser(User user) {
        boolean isName=this.isExists(" and username='"+user.getUsername()+"' ");
    	String str="录入成功";
    	if(isName){
    		str="1";//存在名称
    	}else{
        		 //加密密码
                passwordHelper.encryptPassword(user);
                userDao.insert(user);
    	}
        return str;
    }

    @ServiceLog(value="更新用户")
    public String updateUser(User user) {
        boolean isName=this.isExists(" and id!="+user.getId()+" and username='"+user.getUsername()+"' ");
     	String str="修改成功";
     	if(isName){
     		str="1";//存在名称
     	}else{
     		userDao.updateByPrimaryKey(user);
     	}
        return str;
    }

    @ServiceLog(value="删除用户")
    public void deleteUser(Long userId) {
        userDao.deleteByPrimaryKey(userId);
    }

    public boolean isExists(String param){
    	List<User> list=userDao.selectByParam(param);
    	boolean flag=false;
    	if(list.size() > 0){
    		flag=true;
    	}
    	return flag;
    }
    
    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    @ServiceLog(value="修改密码")
    public void changePassword(Long userId, String newPassword) {
        User user =userDao.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.updateByPrimaryKey(user);
    }

    @ServiceLog(value="查询单个用户对象")
    public User findOne(Long userId) {
        return userDao.selectByPrimaryKey(userId);
    }

    @ServiceLog(value="查询所有用户信息")
    public List<User> findAll() {
        return userDao.selectAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        return userDao.selectByUserName(username);
    }

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findRoles(this.getListRoleIds(user.getRoleIds()).toArray(new String[0]));
    }

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_SET;
        }
        return roleService.findPermissions(this.getListRoleIds(user.getRoleIds()).toArray(new String[0]));
    }
    
    /**
     * 根据用户名查找其菜单
     * @param username
     * @return
     */
    public List<com.prisys.web.entity.Resource> findResourceList(String username) {
        User user =findByUsername(username);
        if(user == null) {
            return Collections.EMPTY_LIST;
        }
        return roleService.findResourceList(this.getListRoleIds(user.getRoleIds()).toArray(new String[0]));
    }
    
    public List<String> getListRoleIds(String str){
   	 List<String> list=new ArrayList<String>();
   	 if(StringUtils.isEmpty(str)){
   		 return list;
   	 }
   	  String[] roleIdStrs = str.split(",");
	      for(String roleIdStr : roleIdStrs) {
	          if(StringUtils.isEmpty(roleIdStr)) {
	              continue;
	          }
	          list.add(roleIdStr);
	      }
	      return list;
   }


	public List<User> queryUserByParam(String param, Integer page, Integer rows) {
		List<User> userList=userDao.queryUserByParam(param, page, rows);
		for(User user : userList){
			user.setOrgName(this.getOrganizationName(user.getOrganizationId()));
			user.setRoleName(this.getRoleName(user.getRoleIds()));
		}
		return  userList;
	}


	@Override
	public Long queryUserTotalByParam(String param) {
		return userDao.queryUserTotalByParam(param);
	}

	public String getOrganizationName(String organizationId){
		Organization o=organizationService.findOne(organizationId);
		String str=null;
		if(o != null){
			str=o.getName();
		}
		return str;
	}
	
	public String getRoleName(String code){
		Role o=roleService.findOne(code);
		String str=null;
		if(o != null){
			str=o.getName();
		}
		return str;
	}
}
