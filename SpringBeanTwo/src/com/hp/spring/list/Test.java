package com.hp.spring.list;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//��ȡIOC����
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-list.xml");
		//��ȡʵ��
		User user=(User)ac.getBean("user");
		
		System.out.println(user);
	}
}
