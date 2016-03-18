package com.prisys.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.prisys.web.entity.User;

/**
 * 拦截器
 * @author yangl
 *
 */
public class HandlerInterceptor extends HandlerInterceptorAdapter {
	 /** 
     * 在业务处理器处理请求之前被调用 
     * 如果返回false 
     *     从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链 
     *  
     * 如果返回true 
     *    执行下一个拦截器,直到所有的拦截器都执行完毕 
     *    再执行被拦截的Controller 
     *    然后进入拦截器链, 
     *    从最后一个拦截器往回执行所有的postHandle() 
     *    接着再从最后一个拦截器往回执行所有的afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		System.out.println("--------------preHandle---------------");
		//获取URL
		String url=request.getRequestURI();
		if(url==null){
			return false;
		}
		//不拦截的URL
		String[] noInterceptors={"login.do"};
		for(String s:noInterceptors){
			//如果包含在URL中  返回true
			if(url.indexOf(s)>-1){
				return true;
			}
		}
		//获取session中的值
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("userSession");
		if(user!=null){
			System.out.println("用户名："+user.getUsername()+"---密码："+user.getPassword());
			return true;
		}else{
			String basePath=url.split("/")[1];
			response.sendRedirect("/"+basePath+"/login.jsp");
			return false;
		}
	}
	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("--------------postHandle---------------");
	}
	/** 
     * 在DispatcherServlet完全处理完请求后被调用  
     *  
     *   当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion() 
     */  
	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("--------------afterCompletion---------------");
	}


}
