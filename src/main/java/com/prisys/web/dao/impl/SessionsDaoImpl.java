/*
 * 文件名：SessionsDaoImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.SessionsDao;
import com.prisys.web.entity.Sessions;

@SuppressWarnings("all")
@Repository
public class SessionsDaoImpl implements SessionsDao {
	
	@Resource
	private BaseDao<Sessions> baseDao;

	@Override
	public String insert(Sessions record) {
		return (String) baseDao.save(record);
	}

	@Override
	public void updateByPrimaryKey(Sessions record) {
		baseDao.update(record);
	}

	@Override
	public Integer deleteByPrimaryKey(String id) {
		return baseDao.executeHql("delete from Sessions where id=?", new Object[]{id});
	}

	@Override
	public Sessions selectByPrimaryKey(String id) {
		return baseDao.get(Sessions.class, id);
	}

	public List<Sessions> querySessionsList(String param, int start, int size){
		Query query=baseDao.createQuery("from Sessions where 1=1 "+(param == null ? "" : param));
		query.setMaxResults(size);//设置每页显示多少个
		query.setFirstResult(start);//设置起点
		return  query.list();
	}
}
