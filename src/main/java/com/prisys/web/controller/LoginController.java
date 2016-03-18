package com.prisys.web.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prisys.web.utils.BaseController;

import javax.servlet.http.HttpServletRequest;

/**
 * 
* @ClassName: LoginController
* @Description: TODO
* @author yangl
* @date 2015-6-5 下午1:35:36
*
 */
@Controller
public class LoginController extends BaseController{

    @RequestMapping(value = "/login"    )
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        logger.error(error);
        model.addAttribute("error", error);
        return "login";
    }


}
