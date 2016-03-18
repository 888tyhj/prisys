/*
 * 文件名：SessionsServiceImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.web.dao.SessionsDao;
import com.prisys.web.entity.Sessions;
import com.prisys.web.service.SessionsService;

@Service
public class SessionsServiceImpl implements SessionsService {
	
	@Resource
	private SessionsDao sessionsDao;

	@Override
	public String insert(Sessions record) {
		return sessionsDao.insert(record);
	}

	@Override
	public void updateByPrimaryKey(Sessions record) {
		sessionsDao.updateByPrimaryKey(record);
	}

	@Override
	public Integer deleteByPrimaryKey(String id) {
		return sessionsDao.deleteByPrimaryKey(id);
	}

	@Override
	public Sessions selectByPrimaryKey(String id) {
		return sessionsDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Sessions> querySessionsList(String param, int start, int size) {
		return sessionsDao.querySessionsList(param, start, size);
	}

}
