package com.hp.proxy.statiz;

//��ʵ�Ľ�ɫ
public class RealSubject extends Subject{

	@Override
	public void request() {
		System.out.println("doSthing from RealSubject");
		
	}
}
