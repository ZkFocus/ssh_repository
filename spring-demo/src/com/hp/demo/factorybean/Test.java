package com.hp.demo.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-factorybean.xml");
		
		Apple apple =(Apple)ac.getBean("apple");
		
		
		System.out.println(apple);
		
		
	}

}
