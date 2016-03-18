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

import com.prisys.web.entity.User;
import com.prisys.web.service.OrganizationService;
import com.prisys.web.service.RoleService;
import com.prisys.web.service.UserService;
import com.prisys.web.utils.BaseController;

/**
 * 
* @ClassName: UserController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:36:00
*
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource
    private UserService userService;

    @Resource
    private OrganizationService organizationService;
    @Resource
    private RoleService roleService;
    
    @RequiresPermissions("user:view")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
//        model.addAttribute("userList", userService.findAll());
        return "persys/user/list";
    }
    
    @RequiresPermissions("user:view")
    @RequestMapping(value="/listPage",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject listPage(String param, Integer page, Integer rows) {
    	Map<String,Object> map=new HashMap<String,Object>();
		map.put("rows", userService.queryUserByParam(param, page, rows));
    	map.put("total", userService.queryUserTotalByParam(param));
    	JSONObject json=JSONObject.fromObject(map);
		return json;
    }
    
    @RequiresPermissions("user:view")
    @RequestMapping(value="/adduserpage",method = RequestMethod.GET)
    public String adduserpage(String param, Model model) {
    	setCommonData(model);
		return "persys/user/add_user";
    }
    
    @RequiresPermissions("user:view")
    @RequestMapping(value="/edituserpage",method = RequestMethod.GET)
    public String edituserpage(String param, Model model) {
    	setCommonData(model);
		return "persys/user/edit_user";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        model.addAttribute("user", new User());
        model.addAttribute("op", "新增");
        return "persys/user/edit";
    }

    @RequiresPermissions("user:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public String create(User user) {
    	String message="录入成功";
    	try {
    		message=userService.createUser(user);
		} catch (Exception e) {
			message="录入失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "修改");
        return "persys/user/edit";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public String update(User user) {
        String message="修改成功";
    	try {
    		message=userService.updateUser(user);
		} catch (Exception e) {
			message="修改失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("op", "删除");
        return "persys/user/edit";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public String delete(@PathVariable("id") Long id) {
        String message="删除成功";
    	try {
    		userService.deleteUser(id);
		} catch (Exception e) {
			message="删除失败";
			logger.error(e.getMessage());
		}
        return message;
    }


    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.GET)
    public String showChangePasswordForm(@PathVariable("id") Long id) {
//        model.addAttribute("user", userService.findOne(id));
//        model.addAttribute("op", "修改密码");
        return "persys/user/changePassword";
    }

    @RequiresPermissions("user:update")
    @RequestMapping(value = "/{id}/changePassword", method = RequestMethod.POST)
    @ResponseBody
    public String changePassword(@PathVariable("id") Long id, String newPassword) {
        String message="修改成功";
    	try {
    		userService.changePassword(id, newPassword);
		} catch (Exception e) {
			message="修改失败";
			logger.error(e.getMessage());
		}
        return message;
    }

    private void setCommonData(Model model) {
        //model.addAttribute("organizationList", organizationService.findAll());
        model.addAttribute("roleList", roleService.findAll());
    }

}
