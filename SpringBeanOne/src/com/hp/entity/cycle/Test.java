package com.hp.entity.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//����IOC����
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("beans-cycle.xml");
		//��ȡʵ��
		HelloWorld hw=(HelloWorld)ac.getBean("hw");
		System.out.println(hw);
		
		ac.close();
	}

}
