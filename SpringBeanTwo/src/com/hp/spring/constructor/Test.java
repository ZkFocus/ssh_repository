package com.hp.spring.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//1 ��������
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-constructor.xml");
		
		//2 ��ȡbean����
		Apple apple=(Apple)ac.getBean("apple2");
		
		System.out.println(apple);
	}

}
