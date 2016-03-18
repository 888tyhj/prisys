package com.prisys.web.service;



public interface SchedulerService {
//	 void run();
	 void run2();
	 void runBean(String beanName,String methodName);
	 void runBean2();
	
	 void createRunJobByJobId(Long id);
	 void createStopJobByJobId(Long id);
	 void deleteByPrimaryKey(Long id);
}
