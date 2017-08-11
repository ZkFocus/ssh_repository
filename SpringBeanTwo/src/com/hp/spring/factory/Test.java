package com.hp.spring.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		//����IOC����
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-factory.xml");
		//��ȡʵ��
		/*Apple apple =(Apple)ac.getBean("apple");
		System.out.println(apple);*/
		
		
		Apple apple2 =(Apple)ac.getBean("apple2");
		System.out.println(apple2);
	}
}
