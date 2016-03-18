/*
 * 文件名：LogService.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service;

import java.util.Map;

import com.prisys.web.entity.Log;

public interface LogService {
	
    void saveLog(Log log);
	
	Integer deleteLog(String id);
	
	Map<String,Object> queryLogByparam(String param, Integer page, Integer rows);
	
}
