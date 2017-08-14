package com.hp.demo.introducation;

import com.hp.demo.introducation.spring.BeanFactory;
import com.hp.demo.introducation.spring.ClassPathXmlApplicationContext;
import com.hp.demo.introducation.traditional.IHello;

public class Test {

	public static void main(String[] args) throws Exception {
		testAdd();
	}
	
	public static void testAdd() throws Exception {
		BeanFactory applicationContext = new ClassPathXmlApplicationContext();
		IHello say = (IHello)applicationContext.getBean("ehello");
		say.sayHello();
	}
}
