package com.hp.proxy.dynamatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {
	
	public static void main(String[] args) {
		//初始化真实角色
		RealSubject rs=new RealSubject();
		//传入角色
		InvocationHandler ds= new DynamicProxy(rs);
		//通过代理产生代理对象
		Subject subject =(Subject)Proxy.newProxyInstance(rs.getClass().getClassLoader(), rs.getClass().getInterfaces(), ds);
		subject.request();
	}
}
