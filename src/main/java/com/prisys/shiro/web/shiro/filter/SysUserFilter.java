package com.prisys.shiro.web.shiro.filter;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import com.prisys.web.service.UserService;
import com.prisys.web.utils.Constants;

/**
 * 
* @ClassName: SysUserFilter
* @Description: TODO
* @author yangl
* @date 2015-6-3 下午1:14:00
*
 */
public class SysUserFilter extends PathMatchingFilter {

    @Resource
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUsername(username));
        return true;
    }
}
