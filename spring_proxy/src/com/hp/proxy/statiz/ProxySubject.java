package com.hp.proxy.statiz;

//代理类 包含了抽象角色
public class ProxySubject extends Subject{
	//包含抽象角色
	private Subject subject;
	
	
	
	public ProxySubject(Subject subject) {
		super();
		this.subject = subject;
	}



	@Override
	public void request() {
		preRequest();
		subject.request();
		postRequest();
		
	}



	private void postRequest() {
		System.out.println("doOthering from Proxy after RealSubject");
	}



	private void preRequest() {
		System.out.println("doOthering from Proxy before RealSubject");
		
	}
	
}
