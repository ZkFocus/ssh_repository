package com.hp.demo.factory;

import com.hp.demo.IHello;

public class Test {

	public static void main(String[] args) {
		IHello hello= BeanFactory.getInstance();
		hello.say();
	}
}
