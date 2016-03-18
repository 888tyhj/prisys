package com.prisys.web.dao; 

import java.util.List;

import com.prisys.web.entity.Test;

/**      
 * TestDao.java Create on 2015-5-29     
 * Copyright (c) 2015-5-29 by http://www.zy-iot.com        
 * @author <a href="yangl@zy-iot.com">YangLei</a>         
 */
public interface TestDao {
	public List<Test> findAll();
}
 