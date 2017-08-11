package com.hp.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class Audience {
	
	@Pointcut("execution(* com.hp.aop.spring.Performance.perform(..))")
	public void pointCut(){}
	
	/**
	 * 前置通知（ Before）：在目标方法被调用之前调用通知功能；
	 */
	@Before("pointCut()")
	public void before(){
		System.out.println("关闭手机操作------------");
	}
	
	@Before("pointCut()")
	public void takeSeat(){
		System.out.println("坐下座位-------------");
	}
	
	/**
	 * 后置通知；不管目标方法是否会发生异常 都会执行
	 */
	/*
	@After("pointCut()")
	public void goHome(){
		System.out.println("goHome........");
	}*/
	
/*	
	 * 异常通知（ After-throwing）：在目标方法抛出异常后调用通知
	 
	
	@AfterThrowing("pointCut()")
	public void afterThrowing(){
		System.out.println("退款。。。。。");
	}
	*/
	/**
	 * 返回通知（ After-returning）：在目标方法成功执行之后调用通知；
	
	 */
	@AfterReturning("pointCut()")
	public void clap(){
		System.out.println("CLAP....CLAP....--------------");
	}
	

	/**
	 * 
	 * @param pj
	 * @throws Throwable
	 *//*
	@Around("pointCut()")
	public void around(ProceedingJoinPoint pj) throws Throwable{
		System.out.println("关闭手机");
		System.out.println("坐下座位");
		
		pj.proceed();
		
		System.out.println("鼓掌");
		
	}*/

	
}
