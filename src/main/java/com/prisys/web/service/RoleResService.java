/*
 * 文件名：RoleResService.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service;

import java.util.List;

import com.prisys.web.entity.RoleRes;

public interface RoleResService {
	
    void saveRoleRes(String resIds, Long roleId);
	
	List<RoleRes> queryRoleResListByRoleId(Long roleId);
	
	Integer deleteRoleResByRoleId(Long roleId);
}
