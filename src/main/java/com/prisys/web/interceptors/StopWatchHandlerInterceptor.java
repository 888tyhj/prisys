package com.prisys.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 记录请求的处理时间,得到一些慢请求（如处理时间超过500毫秒）
 * 
 * @author yangl
 *
 */
public class StopWatchHandlerInterceptor extends HandlerInterceptorAdapter {
	/**
	 * 拦截器是实现成单例的，因此不管用户请求多少次都只有一个拦截器实
		现，即线程不安全，那我们应该怎么记录时间呢？
		解决方案是：使用ThreadLocal，它是线程绑定的变量，提供线程局部变量
		（一个线程一个ThreadLocal，A线程的ThreadLocal只能看到A线程的
		ThreadLocal，不能看到B线程的ThreadLocal）。
	 */
	private NamedThreadLocal<Long> startTimeThreadLocal
	           =new NamedThreadLocal<Long>("StopWatch-StartTime");

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
		System.out.println("--------------time+++preHandle---------------");
		long beginTime=System.currentTimeMillis();//1、开始时间
		startTimeThreadLocal.set(beginTime);//线程绑定变量（该数据只有当前请求的线程可见）
		return true;
	}
	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 
	 */
	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("--------------time+++postHandle---------------");
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
		System.out.println("--------------time+++afterCompletion---------------");
		long endTime = System.currentTimeMillis();//2、结束时间
		long beginTime =startTimeThreadLocal.get();//得到线程绑定的局部变量（开始时间）
		long consumeTime= endTime - beginTime;//3、消耗的时间
		if(consumeTime >500) {//此处认为处理时间超过500毫秒的请求为慢请求
			//TODO 记录到日志文件
			System.out.println(
			String.format("%s consume %d millis", request.getRequestURI(), consumeTime));
		}   
	}

}
