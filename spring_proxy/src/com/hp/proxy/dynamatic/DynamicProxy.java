package com.hp.proxy.dynamatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//动态代理
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
		//处理被代理对象的方法
		method.invoke(subject, args);
		System.out.println("doOthering from Proxy after RealSubject");
		return null;
	}
}
