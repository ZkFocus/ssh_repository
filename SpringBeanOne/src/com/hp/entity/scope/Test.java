package com.hp.entity.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//创建IOC容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-scope.xml");
		//获取实例
		Apple apple=(Apple)ac.getBean("apple");

		Apple apple2=(Apple)ac.getBean("apple");
		
		
		System.out.println(apple==apple2);

				
	}

}
