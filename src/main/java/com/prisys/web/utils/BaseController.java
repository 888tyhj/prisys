/*
 * 文件名：BaseController.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月12日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.utils;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.prisys.shiro.web.bind.annotation.CurrentUser;
import com.prisys.web.bean.Tree;
import com.prisys.web.entity.User;
import com.prisys.web.service.ResourceService;

public class BaseController {
	 /**本地异常日志记录对象  */
    protected static  final Logger logger = LoggerFactory.getLogger(BaseController.class);
    @Resource
    private ResourceService resourceService;
    
    @ModelAttribute("menus")
    public List<Tree> resourceResource(@CurrentUser User loginUser) {
//        return userService.findResourceList(loginUser.getUsername());
    	if(loginUser==null){
    		return Collections.EMPTY_LIST;
    	}
    	return  resourceService.findMenuResourceTree(loginUser.getUsername());
    }
    
}
