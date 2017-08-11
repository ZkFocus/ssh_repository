package com.hp.spring.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCollection {

	public static void main(String[] args) {
		ApplicationContext ac=new ClassPathXmlApplicationContext("collection.xml");
		CollectionBean cb=(CollectionBean) ac.getBean("collectionBean");
		System.out.println(cb);
	}
}
