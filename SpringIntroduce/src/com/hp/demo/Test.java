package com.hp.demo;

public class Test {
	public static void main(String[] args) {
		//�й�������
//		IHello hello=new CHello();
		//Ӣ�����Hello
		IHello hello=new EHello();
		hello.say();
	}
}
