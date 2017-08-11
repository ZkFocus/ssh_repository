package com.spring.future;

import java.io.IOException;

import org.jdom.JDOMException;

import com.spring.old.IHello;

public class TestSpringDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, JDOMException, IOException {
		ApplicationContext ac=new ClassPathXMLApplicationContext();
		IHello hello=(IHello) ac.getBean("ehw");
		hello.sayHello();
	}
}
