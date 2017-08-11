package com.hp.proxy.dynamatic;

public class RealSubject implements Subject{

	
	
	public RealSubject() {
		super();
	}

	@Override
	public void request() {
		System.out.println("do something from realsubejct");
		
	}
}
