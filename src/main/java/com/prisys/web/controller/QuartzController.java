package com.prisys.web.controller;


import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.service.SchedulerService;
import com.prisys.web.utils.BaseController;

@Controller
@RequestMapping("/quartz")
public class QuartzController extends BaseController{
    
	@Resource
	private SchedulerService schedulerService;
	
	@RequestMapping(value="/execute")
	@ResponseBody
	public String executeQuartz(String beanName, String methodName){
		String mes="已成功加入!";
		try {
			schedulerService.runBean(beanName, methodName);
			System.out.println("已加入！！！！！！！！！！！！！！！");
		} catch (Exception e) {
			mes=e.getMessage();
		}
		return mes;
	}
	
	@RequiresPermissions("job:run")
	@RequestMapping(value="/{id}/execute")
	@ResponseBody
	public String executeQuartz(@PathVariable Long id){
		String mes="成功加入";
		try {
			schedulerService.createRunJobByJobId(id);
		} catch (Exception e) {
			mes=e.getMessage();
			logger.error(mes);
		}
		return mes;
	}
	
	@RequiresPermissions("job:run")
	@RequestMapping(value="/{id}/stop")
	@ResponseBody
	public String stopQuartz(@PathVariable Long id){
		String mes="成功加入";
		try {
			schedulerService.createStopJobByJobId(id);
		} catch (Exception e) {
			mes=e.getMessage();
			logger.error(mes);
		}
		return mes;
	}
	
	@RequiresPermissions("job:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        String message="删除成功";
    	try {
    		schedulerService.deleteByPrimaryKey(id);
		} catch (Exception e) {
			message="删除失败";
			logger.error(e.getMessage());
		}
        return message;
    }
	
	@RequestMapping("/execute2")
	public void executeQuartz2(){
		schedulerService.runBean2();
		System.out.println("已加入！！！！！！！！！！！！！！！");
	}
}
