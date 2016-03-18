package com.prisys.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prisys.shiro.web.bind.annotation.CurrentUser;
import com.prisys.web.entity.Resource;
import com.prisys.web.entity.User;
import com.prisys.web.service.ResourceService;
import com.prisys.web.service.UserService;
import com.prisys.web.utils.BaseController;

/**
 * 
* @ClassName: IndexController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:35:29
*
 */
@Controller
public class IndexController extends BaseController{

    @javax.annotation.Resource
    private ResourceService resourceService;
    @javax.annotation.Resource
    private UserService userService;

    @RequestMapping("/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
    
    @RequestMapping("/forwardindex")
    public String forwardindex(String url) {
        return url;
    }
    
    @RequestMapping("/persys/left")
    public String persys(@CurrentUser User loginUser, Model model) {
    	List<Resource> menus=userService.findResourceList(loginUser.getUsername());
    	model.addAttribute("menus", menus);
        return "persys/left";
    }


}
