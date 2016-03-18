/*
 * 文件名：SysJobController.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月19日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.controller;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.entity.SysJob;
import com.prisys.web.service.SysJobService;
import com.prisys.web.utils.BaseController;

@Controller
@RequestMapping("/sysjob")
public class SysJobController extends BaseController {
	@Resource
    private SysJobService sysJobService;
	
	@RequiresPermissions("job:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        return "persys/job/list";
    }
	
	@RequiresPermissions("job:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param) {
    	JSONObject json=JSONObject.fromObject(sysJobService.querySysJobList(param));
		return json;
    }
	
	@RequiresPermissions("job:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(SysJob job) {
        String message="录入成功";
    	try {
    		message=sysJobService.insert(job);
		} catch (Exception e) {
			message="录入失败";
			logger.error(e.getMessage());
		}
        return message;
    }
	
	@RequiresPermissions("job:update")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(SysJob job) {
        String message="修改成功";
    	try {
    		message=sysJobService.updateByPrimaryKey(job);
		} catch (Exception e) {
			message="修改失败";
			logger.error(e.getMessage());
		}
        return message;
    }
	
	@RequiresPermissions("job:view")
    @RequestMapping(value="/addpage", method = RequestMethod.GET)
    public String addpage(Model model) {
        return "persys/job/add_job";
    }
}
