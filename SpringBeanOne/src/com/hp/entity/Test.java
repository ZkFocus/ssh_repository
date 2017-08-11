package com.hp.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-helloworld.xml");
		
		HelloWorld hw=(HelloWorld) ac.getBean("hw");
		
		System.out.println(hw);
	}

}
