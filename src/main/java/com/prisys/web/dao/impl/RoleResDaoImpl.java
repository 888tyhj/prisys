/*
 * 文件名：RoleResDaoImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.RoleResDao;
import com.prisys.web.entity.RoleRes;

@Repository
public class RoleResDaoImpl implements RoleResDao {
	
	@Resource
	private BaseDao<RoleRes> baseDao;

	@Override
	public Long saveRoleRes(RoleRes r) {
		return (Long) baseDao.save(r);
	}

	@Override
	public List<RoleRes> queryRoleResListByRoleId(Long roleId) {
		return baseDao.find("from RoleRes where role_id= "+roleId);
	}

	@Override
	public Integer deleteRoleResByRoleId(Long roleId) {
		return baseDao.executeHql("delete from RoleRes where role_id=?", new Object[]{roleId});
	}

}
