/*
 * 文件名：SessionsDao.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月18日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao;

import java.util.List;

import com.prisys.web.entity.Sessions;

public interface SessionsDao {
	
	String insert(Sessions record);

	void updateByPrimaryKey(Sessions record);

    Integer deleteByPrimaryKey(String id);
    
    Sessions selectByPrimaryKey(String id);
    /**
     * 分页显示
     * @author yangl
     * @version 2015年12月18日
     * @param param 查询条件
     * @param start 起始记录
     * @param size 每页显示的个数
     * @return
     * @see 1.0
     */
    List<Sessions> querySessionsList(String param, int start, int size);
    
}
