package com.spring.now;

import com.spring.old.IHello;

public class TestFactory {

	public static void main(String[] args) {
		String type="english";
		IHello hello=BeanFactory.getInstance(type);
		hello.sayHello();
	}
}
