package com.prisys.web.service;

import java.util.List;
import java.util.Set;

import com.prisys.web.entity.Resource;
import com.prisys.web.entity.Role;

/**
* @ClassName: RoleService
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:08:54
*
 */
public interface RoleService {


	String createRole(Role role);
	String updateRole(Role role);
    void deleteRole(Long roleId);

    Role findOne(Long roleId);
    Role findOne(String code);
    List<Role> findAll();

    /**
     * 根据角色编号得到角色标识符列表
     * @param roleIds
     * @return
     */
    Set<String> findRoles(String... roleIds);

    /**
     * 根据角色编号得到权限字符串列表
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(String[] roleIds);
    List<Role> queryRoleByParam(String param, Integer page, Integer rows);
	Long queryRoleTotalByParam(String param);
	/**
     * 根据角色编号得到菜单列表
     * @param roleIds
     * @return
     */
	List<Resource> findResourceList(String[] roleIds);
}
