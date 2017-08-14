package com.hp.demo.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("beans-cycle.xml");
		
		Apple apple=(Apple)ac.getBean("apple");
		
		
		System.out.println(apple);
		
		
		ac.close();
	}

}
