package com.hp.entity.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//����IOC����
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-scope.xml");
		//��ȡʵ��
		Apple apple=(Apple)ac.getBean("apple");

		Apple apple2=(Apple)ac.getBean("apple");
		
		
		System.out.println(apple==apple2);

				
	}

}
