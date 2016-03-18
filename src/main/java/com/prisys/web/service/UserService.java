package com.prisys.web.service;

import java.util.List;
import java.util.Set;

import com.prisys.web.entity.User;

/**
 * 
* @ClassName: UserService
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:10:04
*
 */
 public interface UserService {

    /**
     * 创建用户
     * @param user
     */
	 String createUser(User user);

	 String updateUser(User user);

     void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
     void changePassword(Long userId, String newPassword);


    User findOne(Long userId);

    List<User> findAll();

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
     User findByUsername(String username);

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
     Set<String> findRoles(String username);

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
     Set<String> findPermissions(String username);

	 List<User> queryUserByParam(String param, Integer page, Integer rows);

	 Long queryUserTotalByParam(String param);
	 
	 List<com.prisys.web.entity.Resource> findResourceList(String username);

}
