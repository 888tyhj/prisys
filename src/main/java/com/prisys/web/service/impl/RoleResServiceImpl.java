/*
 * 文件名：RoleResServiceImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.web.dao.RoleResDao;
import com.prisys.web.entity.RoleRes;
import com.prisys.web.service.RoleResService;

@Service
public class RoleResServiceImpl implements RoleResService {
	
	@Resource
	private RoleResDao roleResDao;

	@Override
	public void saveRoleRes(String resIds, Long roleId) {
		this.deleteRoleResByRoleId(roleId);
		if(resIds!=null && !resIds.equals("")){
			String[] arr=resIds.split(",");
			RoleRes r=null;
			for(String resID:arr){
				r=new RoleRes();
				r.setResID(Long.parseLong(resID));
				r.setRoleId(roleId);
				roleResDao.saveRoleRes(r);
			}
		}
	}

	@Override
	public List<RoleRes> queryRoleResListByRoleId(Long roleId) {
		return roleResDao.queryRoleResListByRoleId(roleId);
	}

	@Override
	public Integer deleteRoleResByRoleId(Long roleId) {
		return roleResDao.deleteRoleResByRoleId(roleId);
	}

}
