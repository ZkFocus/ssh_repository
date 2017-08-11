package com.hp.proxy.statiz;

//真实的角色
public class RealSubject extends Subject{

	@Override
	public void request() {
		System.out.println("doSthing from RealSubject");
		
	}
}
