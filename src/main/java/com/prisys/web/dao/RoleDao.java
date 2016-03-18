package com.prisys.web.dao;


import java.util.List;

import com.prisys.web.entity.Role;

public interface RoleDao {
	Integer deleteByPrimaryKey(Long id);

    Long insert(Role record);

    Role selectByPrimaryKey(Long id);
    
    List<Role> selectAll();

    void updateByPrimaryKey(Role record);

	List<Role> queryRoleByParam(String param, Integer page, Integer rows);

	Long queryRoleTotalByParam(String param);
	
	List<Role> selectByParam(String param);
}