/*
 * 文件名：RoleResDao.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao;

import java.util.List;

import com.prisys.web.entity.RoleRes;

public interface RoleResDao {

	Long saveRoleRes(RoleRes r);
	
	List<RoleRes> queryRoleResListByRoleId(Long roleId);
	
	Integer deleteRoleResByRoleId(Long roleId);
	
}
