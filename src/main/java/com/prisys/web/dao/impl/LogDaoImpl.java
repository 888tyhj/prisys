/*
 * 文件名：LogDaoImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
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
import com.prisys.web.dao.LogDao;
import com.prisys.web.entity.Log;

@SuppressWarnings("all")
@Repository
public class LogDaoImpl implements LogDao{
	
	@Resource
	private BaseDao<Log> baseDao;

	@Override
	public void saveLog(Log log) {
		baseDao.save(log);
	}

	@Override
	public Integer deleteLog(String id) {
		return baseDao.executeHql("delete from Log where id=?", new Object[]{id});
	}

	@Override
	public List<Log> queryLogByparam(String param, Integer page, Integer rows) {
		Query q=baseDao.createQuery("from Log where 1=1 "+ (param==null?"":param)+" order by createtime desc ");
		//设置每页显示多少个
		q.setMaxResults(rows);
		//设置起点
		q.setFirstResult((rows*(page-1)));
		return q.list();
	}

	@Override
	public Long queryCountLogByParam(String param) {
		return baseDao.count("select count(*) from Log where 1=1 "+ (param==null?"":param));
	}

}
