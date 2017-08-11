package com.hp.entity.cycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		//创建IOC容器
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("beans-cycle.xml");
		//获取实例
		HelloWorld hw=(HelloWorld)ac.getBean("hw");
		System.out.println(hw);
		
		ac.close();
	}

}
