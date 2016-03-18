/**      
 * UserDaoImpl.java Create on 20l15-6-3     
 * Copyright (c) 20l15-6-3 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
package com.prisys.web.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.UserDao;
import com.prisys.web.entity.User;

@SuppressWarnings("all")
@Repository
public class UserDaoImpl implements UserDao {
	
	@Resource
	private BaseDao<User> baseDao;

	public Integer deleteByPrimaryKey(Long id) {
		return baseDao.executeHql("delete from User where id=?", new Object[]{id});
	}

	public Long insert(User record) {
		return (Long) baseDao.save(record);
	}

	public User selectByPrimaryKey(Long id) {
		return baseDao.get(User.class, id);
	}

	public User selectByUserName(String userName) {
		return baseDao.get("from User where username=?", new Object[]{userName});
	}

	public List<User> selectAll() {
		return baseDao.find("from User");
	}
	
	public List<User> selectByParam(String param) {
		return baseDao.find("from User where 1=1 "+ (param==null?"":param));
	}

	public void updateByPrimaryKey(User record) {
		baseDao.update(record);
	}

	@Override
	public List<User> queryUserByParam(String param, Integer page, Integer rows) {
		Query q=baseDao.createQuery("from User where isshow=2 "+ (param==null?"":param));
		//设置每页显示多少个
		q.setMaxResults(rows);
		//设置起点
		q.setFirstResult((rows*(page-1)));
		return q.list();
	}

	@Override
	public Long queryUserTotalByParam(String param) {
		return baseDao.count("select count(*) from User where isshow=2 "+ (param==null?"":param));
	}

}
 