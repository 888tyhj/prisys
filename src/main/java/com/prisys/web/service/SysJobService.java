/*
 * 文件名：SysJobService.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.service;

import java.util.Map;

import com.prisys.web.entity.SysJob;

public interface SysJobService {
	String insert(SysJob record);

	String updateByPrimaryKey(SysJob record);

    Map<String, Object> querySysJobList(String param);
}
