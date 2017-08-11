package com.spring.demo.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		HelloWorld hw=(HelloWorld) ac.getBean("hw");
		
		System.out.println(hw);
		
	}
}
