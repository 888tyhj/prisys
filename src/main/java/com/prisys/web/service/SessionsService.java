/*
 * 文件名：SessionsService.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service;

import java.util.List;

import com.prisys.web.entity.Sessions;

public interface SessionsService {
	String insert(Sessions record);

	void updateByPrimaryKey(Sessions record);

    Integer deleteByPrimaryKey(String id);
    
    Sessions selectByPrimaryKey(String id);
    
    List<Sessions> querySessionsList(String param, int start, int size);
}
