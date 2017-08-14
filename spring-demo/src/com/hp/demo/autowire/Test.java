package com.hp.demo.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean-auto.xml");
		
		Teacher teacher=(Teacher)ac.getBean("teacher");
		
		System.out.println(teacher);
	}

}
