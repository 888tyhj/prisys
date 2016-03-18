package com.prisys.web.controller;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.service.LogService;
import com.prisys.web.utils.BaseController;

/**
 * 日志
 * @author yangl
 * @version 2015年12月15日
 * @see LogController
 * @since 1.0
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController{

    @Resource
    private LogService logService;
    
    @RequiresPermissions("log:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        return "persys/log/list";
    }
    
    @RequiresPermissions("log:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param, Integer page, Integer rows) {
    	JSONObject json=JSONObject.fromObject(logService.queryLogByparam(param, page, rows));
		return json;
    }

}
