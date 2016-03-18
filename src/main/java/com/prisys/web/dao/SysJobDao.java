/*
 * 文件名：SysJobDao.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.dao;

import java.util.List;

import com.prisys.web.entity.SysJob;

public interface SysJobDao {
	Long insert(SysJob record);

	void updateByPrimaryKey(SysJob record);

    Integer deleteByPrimaryKey(Long id);
    
    SysJob selectByPrimaryKey(Long id);
    
    List<SysJob> querySysJobList(String param);

	void deleteSysJob(SysJob sysJob);
}
