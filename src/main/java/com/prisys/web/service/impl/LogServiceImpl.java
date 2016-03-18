/*
 * 文件名：LogServiceImpl.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.web.dao.LogDao;
import com.prisys.web.entity.Log;
import com.prisys.web.service.LogService;

@Service
public class LogServiceImpl implements LogService{
	
	@Resource
	private LogDao logDao;

	@Override
	public void saveLog(Log log) {
		logDao.saveLog(log);
	}

	@Override
	public Integer deleteLog(String id) {
		return logDao.deleteLog(id);
	}

	@Override
	public Map<String, Object> queryLogByparam(String param, Integer page,
			Integer rows) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", logDao.queryLogByparam(param, page, rows));
    	map.put("total", logDao.queryCountLogByParam(param));
		return map;
	}

}
