package com.hp.demo.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		//创建IOC容器
		//ApplicationContext代表spring IOC容器
		//在 Spring IOC 容器读取 Bean 配置创建 Bean 实例之前, 必须对它进行实例化. 
		//只有在容器实例化后, 才可以从 IOC 容器里获取 Bean 实例并使用
		//ClassPathXmlApplicationContext 从类路径下加载配置文件
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//HelloWorld hw=ac.getBean(HelloWorld.class);
		//利用bean的类型返回bean。缺点 必须保证IOC容器中bean类型的唯一
//		HelloWorld hw=(HelloWorld)ac.getBean("hw");
		
		/*HelloWorld hw=(HelloWorld)ac.getBean("helloworld");
		
		hw.sayHello();*/
		
		/*Apple apple=(Apple)ac.getBean("apple3");
		System.out.println(apple);
		
		Product p=(Product)ac.getBean("p");
		System.out.println(p);
		
		
		User user=(User)ac.getBean("user");
		System.out.println(user);
		
		UserMap uMap=(UserMap)ac.getBean("userMap");
		System.out.println(uMap);
		
		
		User userUtil=(User)ac.getBean("userUtil");
		System.out.println(userUtil);
		
		HelloWorld hw3=(HelloWorld)ac.getBean("helloworld3");
		
		hw3.sayHello();*/
	}
}
