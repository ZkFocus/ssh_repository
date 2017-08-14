package com.hp.demo.entity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
	public static void main(String[] args) {
		//����IOC����
		//ApplicationContext����spring IOC����
		//�� Spring IOC ������ȡ Bean ���ô��� Bean ʵ��֮ǰ, �����������ʵ����. 
		//ֻ��������ʵ������, �ſ��Դ� IOC �������ȡ Bean ʵ����ʹ��
		//ClassPathXmlApplicationContext ����·���¼��������ļ�
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//HelloWorld hw=ac.getBean(HelloWorld.class);
		//����bean�����ͷ���bean��ȱ�� ���뱣֤IOC������bean���͵�Ψһ
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
