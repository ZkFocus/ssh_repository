package com.hp.spring.relation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-relations.xml");
		
		Address address=(Address)ac.getBean("address");
		
		System.out.println(address);
	}
}
