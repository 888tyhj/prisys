/*
 * 文件名：RoleResController.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月13日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.controller;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.service.RoleResService;
import com.prisys.web.utils.BaseController;

@Controller
@RequestMapping("/roleres")
public class RoleResController extends BaseController{
	
	@Resource
    private RoleResService roleResService;
	
	@RequiresPermissions("role:resource")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(String resIds, Long roleId) {
        String message="录入成功";
    	try {
    		roleResService.saveRoleRes(resIds, roleId);
		} catch (Exception e) {
			message="录入失败";
			logger.error(e.getMessage());
		}
        return message;
    }

	@RequiresPermissions("role:resource")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONArray listPage(Long roleId) {
    	JSONArray json=JSONArray.fromObject(roleResService.queryRoleResListByRoleId(roleId));
		return json;
    }
}
