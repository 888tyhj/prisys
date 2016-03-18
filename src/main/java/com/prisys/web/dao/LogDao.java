/*
 * 文件名：LogDao.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao;

import java.util.List;

import com.prisys.web.entity.Log;

public interface LogDao {

	void saveLog(Log log);
	
	Integer deleteLog(String id);
	
	List<Log> queryLogByparam(String param, Integer page, Integer rows);
	
	Long queryCountLogByParam(String param);
}
