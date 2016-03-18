/*
 * 文件名：SystemLogAspect.java
 * 版权：Copyright by http://www.zy-iot.com
 * 描述：
 * 修改人：yangl
 * 修改时间：2015年12月11日
 * 跟踪单号：
 * 修改单号：
 * 修改内容：
 */

package com.prisys.web.aop;

import java.lang.reflect.Method;
import java.net.InetAddress;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.prisys.shiro.web.bind.annotation.ControllerLog;
import com.prisys.shiro.web.bind.annotation.ServiceLog;
import com.prisys.web.entity.Log;
import com.prisys.web.entity.User;
import com.prisys.web.service.LogService;
import com.prisys.web.utils.Constants;
import com.prisys.web.utils.DateUtil;

/**
 * 系统日志记录
 * @author yangl
 * @version 2015年12月11日
 * @see SystemLogAspect
 * @since 1.0
 */
@SuppressWarnings("all")
@Aspect
@Component
public class SystemLogAspect {

	@Resource
	private  LogService logService;
	
	//本地异常日志记录对象    
    private  static  final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
	
     /**service切入点*/
	@Pointcut("@annotation(com.prisys.shiro.web.bind.annotation.ServiceLog)")
	private void serviceAspect(){}

	@Pointcut("@annotation(com.prisys.shiro.web.bind.annotation.ControllerLog)")
	private void controllerAspect(){}
    /**
     * 用于拦截service层记录
     * @author yangl
     * @version 2015年12月11日
     * @param point
     * @return
     * @see 1.0
     */
	@Around("serviceAspect()")
	public Object invoke(ProceedingJoinPoint point){
		Object result = null;
		try {
			//执行方法名
			String name = point.getSignature().getName();
			String className=point.getTarget().getClass().getName();
			Long start = System.currentTimeMillis();
			result = point.proceed();
			Long end = System.currentTimeMillis();
//			if (name.indexOf("saveYjjl") > -1) {
//			    return result;
//			}
			//当前用户
			ServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//	        HttpSession session = request.getSession();  
	        Object obj=request.getAttribute(Constants.CURRENT_USER);
	        User user=null;
	        if(obj!=null){
	        	user=(User)obj;
	        }
			//操作类型
			String opertype = "";
			if(name.contains("save")||name.contains("create")){
				opertype = "保存";
			}else if(name.contains("update")){
				opertype = "更新";
			}else if(name.contains("delete")){
				opertype = "删除";
			}else{
				opertype="查询";
			}
			//操作内容
			String content =this.getServiceMethodValue(point);
			//ip
			InetAddress host = InetAddress.getLocalHost();
			String createip = host.getHostAddress();
			//所耗时间
			Long cost = end - start;
			//日志时间
			String logtime=DateUtil.getyyyyMMddHHmmsssplit();
			//备注
			String memo = name;
			String userName=null;
			if(user!=null){
				userName=user.getRealname();
			}
			//模块
			String mod="";
			
			//获取用户请求方法的参数并序列化为JSON格式字符串    
	        String params = "";    
	         if (point.getArgs() !=  null && point.getArgs().length > 0) {    
	             for ( int i = 0; i < point.getArgs().length; i++) {    
	                params += JSON.toJSONString(point.getArgs()[i]) + ";";    
	            }    
	        }  
	         
			Log log = new Log();
			log.setOpertype(opertype);
			log.setContent(content);
			log.setCost(cost);
			log.setCreateip(createip);
			log.setCreateuser(userName);
			log.setCreatetime(logtime);
			log.setMemo(memo);
			log.setMethodName((className + "." + name + "()")); 
			log.setParams(params);
			log.setMod(mod);
			log.setType(1);
			logService.saveLog(log);
			System.out.println("--------------log log log--------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	/**  
     * 异常通知 用于拦截Controller层记录异常日志  
     *  
     * @param joinPoint  
     * @param e  
     */    
    @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")    
     public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {   
    	String className=joinPoint.getTarget().getClass().getName();
    	String methodName=joinPoint.getSignature().getName();
        ServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        //读取session中的用户    
        Object obj=request.getAttribute(Constants.CURRENT_USER);
        User user=null;
        if(obj!=null){
        	user=(User)obj;
        }   
        //获取请求ip    
        String ip = request.getRemoteAddr();    
        //获取用户请求方法的参数并序列化为JSON格式字符串    
        String params = "";    
         if (joinPoint.getArgs() !=  null && joinPoint.getArgs().length > 0) {    
             for ( int i = 0; i < joinPoint.getArgs().length; i++) {    
                params += JSON.toJSONString(joinPoint.getArgs()[i]) + ";";    
            }    
        }    
         try {    
              /*========控制台输出=========*/    
        	 logger.error("=====异常通知开始=========start=====");    
//            System.out.println("异常代码:" + e.getClass().getName());    
//            System.out.println("异常信息:" + e.getMessage());    
//            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));    
//            System.out.println("方法描述:" + getControllerMethodValue(joinPoint));    
//            System.out.println("请求人:" + user.getRealname());    
//            System.out.println("请求IP:" + ip);    
//            System.out.println("请求参数:" + params); 
        	 
            /*==========数据库日志=========*/    
            Log log = new Log();    
            log.setContent(this.getControllerMethodValue(joinPoint));    
            log.setExceptionCode(e.getClass().getName());    
            log.setType(2);    
            log.setExceptionDetail(e.getMessage());    
            log.setMethodName((className + "." + methodName + "()"));    
            log.setParams(params);    
            String userName=null;
			if(user!=null){
				userName=user.getRealname();
			}
            log.setCreateuser(userName);    
            log.setCreatetime(DateUtil.getyyyyMMddHHmmsssplit());    
            log.setCreateip(ip);    
            //保存数据库    
            logService.saveLog(log);    
        }  catch (Exception ex) {    
            ex.printStackTrace();    
        }    
         /*==========记录本地异常日志==========*/    
        logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}", joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(), e.getMessage(), params);    
        logger.error("=====异常通知结束============end=====");
    }    
	
	/**  
     * 获取注解中对方法的描述信息 用于service层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getServiceMethodValue(JoinPoint joinPoint)    
             throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String value = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    value = method.getAnnotation(ServiceLog.class).value();    
                     break;    
                }    
            }    
        }    
         return value;    
    }    
    
    /**  
     * 获取注解中对方法的描述信息 用于Controller层注解  
     *  
     * @param joinPoint 切点  
     * @return 方法描述  
     * @throws Exception  
     */    
     public  static String getControllerMethodValue(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String value = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    value = method.getAnnotation(ControllerLog. class).value();    
                     break;    
                }    
            }    
        }    
         return value;    
    }    
}
