package com.hp.demo.testMap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-map.xml");
		
		User user=(User)ac.getBean("map");
		
		
		System.out.println(user);
	}
}
