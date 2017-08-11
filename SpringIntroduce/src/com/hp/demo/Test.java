package com.hp.demo;

public class Test {
	public static void main(String[] args) {
		//中国版的你好
//		IHello hello=new CHello();
		//英国版的Hello
		IHello hello=new EHello();
		hello.say();
	}
}
