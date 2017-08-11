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
@Order(2)
public class Audience {

	@Pointcut("execution(* com.spring.aop.demo.Piano.perform())")
	public void pointCut(){}
	
	
	@Before("pointCut()")
	public void turnOffMobile(){
		System.out.println("�ر��ֻ�......");
	}
	
	@AfterReturning("pointCut()")
	public void clap(){
		System.out.println("����.....");
	}
	/*@AfterThrowing("pointCut()")
	public void refund(){
		System.out.println("�˿������");
	}*/
	/*@After("pointCut()")
	public void afterPerform(){
		System.out.println("��������ݵ�ʱ�����ڲ��ڣ��Ҷ���ִ��");
	}*/
	
	/*@Around("pointCut()")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("�ر��ֻ�");
		Object result=proceedingJoinPoint.proceed();
		System.out.println("����");
		return result;
	}*/
}
