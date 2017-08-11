package com.hp.spring.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//获取IOC容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-list.xml");
		//获取实例
		User user=(User)ac.getBean("user");
		
		System.out.println(user);
	}
}
