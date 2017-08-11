package com.hp.spring.ref;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		//创建容器
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-ref.xml");
		//获取bean实例
		User user=(User)ac.getBean("user");
		
		System.out.println(user);
	}
}
