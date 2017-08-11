package com.hp.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//������
public class PerformanceProxy {

	//Ҫ����Ķ���
	private Performance target;

	public PerformanceProxy(Performance target) {
		super();
		this.target = target;
	}
	
	public Performance getLogProxy(){
		Performance proxy=null;
		//��ȡ��������classloader
		ClassLoader cl=target.getClass().getClassLoader();
		Class[] interfaces=new Class[]{Performance.class};
		InvocationHandler h=new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				System.out.println("truning off mobile");
				
				System.out.println("Taking a seat");
				
				Object result=method.invoke(target, args);
				
				System.out.println("CLAP...CLAP...");
				
				return result;
			}
		};
		//�����������
		proxy=(Performance)Proxy.newProxyInstance(cl, interfaces, h);
		return proxy;
	}
}
