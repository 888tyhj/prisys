/*
 * 文件名：SysJobDaoImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.SysJobDao;
import com.prisys.web.entity.SysJob;

@Repository
public class SysJobDaoImpl implements SysJobDao {
	
	@Resource
	private BaseDao<SysJob> baseDao;

	@Override
	public Long insert(SysJob record) {
		return (Long) baseDao.save(record);
	}

	@Override
	public void updateByPrimaryKey(SysJob record) {
		baseDao.update(record);
	}

	@Override
	public Integer deleteByPrimaryKey(Long id) {
		return baseDao.executeHql("delete from SysJob where id=?", new Object[]{id});
	}

	@Override
	public SysJob selectByPrimaryKey(Long id) {
		return baseDao.get(SysJob.class, id);
	}

	@Override
	public List<SysJob> querySysJobList(String param) {
		return baseDao.find("from SysJob where 1=1 "+(param==null?"":param));
	}

	@Override
	public void deleteSysJob(SysJob sysJob) {
		baseDao.delete(sysJob);		
	}

}
