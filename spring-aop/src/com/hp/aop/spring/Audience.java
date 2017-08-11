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
	 * ǰ��֪ͨ�� Before������Ŀ�귽��������֮ǰ����֪ͨ���ܣ�
	 */
	@Before("pointCut()")
	public void before(){
		System.out.println("�ر��ֻ�����------------");
	}
	
	@Before("pointCut()")
	public void takeSeat(){
		System.out.println("������λ-------------");
	}
	
	/**
	 * ����֪ͨ������Ŀ�귽���Ƿ�ᷢ���쳣 ����ִ��
	 */
	/*
	@After("pointCut()")
	public void goHome(){
		System.out.println("goHome........");
	}*/
	
/*	
	 * �쳣֪ͨ�� After-throwing������Ŀ�귽���׳��쳣�����֪ͨ
	 
	
	@AfterThrowing("pointCut()")
	public void afterThrowing(){
		System.out.println("�˿��������");
	}
	*/
	/**
	 * ����֪ͨ�� After-returning������Ŀ�귽���ɹ�ִ��֮�����֪ͨ��
	
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
		System.out.println("�ر��ֻ�");
		System.out.println("������λ");
		
		pj.proceed();
		
		System.out.println("����");
		
	}*/

	
}
