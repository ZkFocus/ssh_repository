package com.hp.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class PerformanceProxy {

	//要代理的对象
	private Performance target;

	public PerformanceProxy(Performance target) {
		super();
		this.target = target;
	}
	
	public Performance getLogProxy(){
		Performance proxy=null;
		//获取代理对象的classloader
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
		//产生代理对象
		proxy=(Performance)Proxy.newProxyInstance(cl, interfaces, h);
		return proxy;
	}
}
