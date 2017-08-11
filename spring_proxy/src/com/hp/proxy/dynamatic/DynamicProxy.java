package com.hp.proxy.dynamatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//��̬����
public class DynamicProxy implements InvocationHandler{

	private Object subject;
	
	
	
	public DynamicProxy() {
		super();
	}



	public DynamicProxy(Object subject) {
		super();
		this.subject = subject;
	}



	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("doOthering from Proxy before RealSubject");
		//�����������ķ���
		method.invoke(subject, args);
		System.out.println("doOthering from Proxy after RealSubject");
		return null;
	}
}
