package com.prisys.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prisys.web.entity.Role;
import com.prisys.web.service.ResourceService;
import com.prisys.web.service.RoleService;
import com.prisys.web.utils.BaseController;

/**
 * 
* @ClassName: RoleController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:35:50
*
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{

    @Resource
    private RoleService roleService;

    @Resource
    private ResourceService resourceService;

    @RequiresPermissions("role:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
//        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("resourceList", resourceService.findAll());
        return "persys/role/list";
    }
    
    @RequiresPermissions("role:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param, Integer page, Integer rows) {
    	Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", roleService.queryRoleByParam(param, page, rows));
    	map.put("total", roleService.queryRoleTotalByParam(param));
    	JSONObject json=JSONObject.fromObject(map);
		return json;
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("role", new Role());
        model.addAttribute("op", "新增");
        return "persys/role/edit";
    }

    @RequiresPermissions("role:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(Role role) {
        String message="录入成功";
    	try {
    		message=roleService.createRole(role);
		} catch (Exception e) {
			message="录入失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("role", roleService.findOne(id));
        model.addAttribute("op", "修改");
        return "persys/role/edit";
    }

    @RequiresPermissions("role:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(Role role) {
        String message="修改成功";
    	try {
    		message=roleService.updateRole(role);
		} catch (Exception e) {
			message="修改失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("role", roleService.findOne(id));
        model.addAttribute("op", "删除");
        return "persys/role/edit";
    }

    @RequiresPermissions("role:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        String message="删除成功";
    	try {
    		roleService.deleteRole(id);
		} catch (Exception e) {
			message="删除失败";
			logger.error(e.getMessage());
		}
        return message;
    }
    
    @RequiresPermissions("role:view")
    @RequestMapping(value = "/addpage", method = RequestMethod.GET)
    public String add() {
        return "persys/role/add";
    }
    
    @RequiresPermissions("role:view")
    @RequestMapping(value = "/right", method = RequestMethod.GET)
    public String right() {
        return "persys/role/right";
    }

    private void setCommonData(Model model) {
        model.addAttribute("resourceList", resourceService.findAll());
    }

}
