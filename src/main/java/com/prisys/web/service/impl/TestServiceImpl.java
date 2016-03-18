package com.prisys.web.service.impl; 

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.prisys.web.dao.TestDao;
import com.prisys.web.entity.Test;
import com.prisys.web.service.TestService;

/**      
 * TestServiceImpl.java Create on 2015-5-29     
 * Copyright (c) 2015-5-29 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
@Service("testService")
public class TestServiceImpl implements TestService {

	@Resource
	private TestDao testDao;
	
	public List<Test> findAll() {
		return testDao.findAll();
	}

}
 