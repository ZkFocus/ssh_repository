package com.hp.demo.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("bean-scope.xml");
		
		Address address1=(Address)ac.getBean("address");
		
		Address address2=(Address)ac.getBean("address");
		
		System.out.println(address1==address2);
		
		
	}

}
