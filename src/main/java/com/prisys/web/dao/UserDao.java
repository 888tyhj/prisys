package com.prisys.web.dao;


import java.util.List;

import com.prisys.web.entity.User;

public interface UserDao {
	
	Integer deleteByPrimaryKey(Long id);

	Long insert(User record);

    User selectByPrimaryKey(Long id);
    
    User selectByUserName(String userName);
    
    List<User> selectAll();

    void updateByPrimaryKey(User record);
    
	List<User> queryUserByParam(String param, Integer page, Integer rows);

	Long queryUserTotalByParam(String param);
	
	List<User> selectByParam(String param);
}