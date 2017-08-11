package com.hp.proxy.dynamatic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {
	
	public static void main(String[] args) {
		//��ʼ����ʵ��ɫ
		RealSubject rs=new RealSubject();
		//�����ɫ
		InvocationHandler ds= new DynamicProxy(rs);
		//ͨ����������������
		Subject subject =(Subject)Proxy.newProxyInstance(rs.getClass().getClassLoader(), rs.getClass().getInterfaces(), ds);
		subject.request();
	}
}
