package com.prisys.web.service;

import java.util.List;

import com.prisys.web.entity.Test;

/**
 * ITestService.java Create on 2015-5-29 Copyright (c) 2015-5-29 by
 * http://www.zy-iot.com
 * 
 * @author <a href="yangl@zy-iot.com">YangLei</a>
 */
public interface TestService {
	public List<Test> findAll();
}
