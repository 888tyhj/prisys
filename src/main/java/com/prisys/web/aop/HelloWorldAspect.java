package com.prisys.web.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * HelloWorldAspect.java Create on 2015-5-17 Copyright (c) 2015-5-17 by
 * http://www.zy-iot.com
 * 
 * @author <a href="yangl@zy-iot.com">YangLei</a>
 */
public class HelloWorldAspect {
	//前置通知
	public void beforeAdvice() {
		System.out.println("==============before advice");
	}
	//前置通知
	public void beforeAdvice(String str) {
		System.out.println("==============before advice "+str);
	}
	
	public void afterReturningAdvice(Object obj){
		System.out.println("==============after returning advice obj="+obj);
	}
	public void afterThrowingAdvice(Exception ex){
		System.out.println("==============after throwing advice exception="+ex);
	}
	//后置最终通知
	public void afterFinallyAdvice(){
		System.out.println("==============after finally advice");
	}
	
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("===========around before advice");
		Object obj=pjp.proceed(new Object[]{"change value"});
		System.out.println("===========around after advice");
		return obj;
	}
}
