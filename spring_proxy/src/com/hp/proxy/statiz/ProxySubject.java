package com.hp.proxy.statiz;

//������ �����˳����ɫ
public class ProxySubject extends Subject{
	//���������ɫ
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
