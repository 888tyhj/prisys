package com.prisys.web.dao.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.prisys.web.base.dao.BaseDao;
import com.prisys.web.dao.TestDao;
import com.prisys.web.entity.Test;

/**      
 * TestDaoImpl.java Create on 2015-5-29     
 * Copyright (c) 2015-5-29 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
@Repository("testDao")
public class TestDaoImpl implements TestDao {

	@Resource
	private BaseDao<Test> baseDao;
	
	public List<Test> findAll() {
		return baseDao.find("from Test order by id");
	}

}
 