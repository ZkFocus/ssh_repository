package com.spring.aop.demo;

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
public class AudienceFromChina {

	@Pointcut("execution(void com.spring.aop.demo.Piano.perform())")
	public void pointCut(){}
	
	
	@Before("pointCut()")
	public void turnOffMobile(){
		System.out.println("关闭手机......From China");
	}
	
	@AfterReturning("pointCut()")
	public void clap(){
		System.out.println("鼓掌.....From China");
	}
	/*@AfterThrowing("pointCut()")
	public void refund(){
		System.out.println("退款。。。。");
	}*/
	/*@After("pointCut()")
	public void afterPerform(){
		System.out.println("不管你表演的时候，人在不在，我都会执行");
	}*/
	
	/*@Around("pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("关闭手机");
		Object result=proceedingJoinPoint.proceed();
		System.out.println("鼓掌");
		return result;
	}*/
}
