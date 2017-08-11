package com.hp.proxy.statiz;

public class ClientTest {
	
	public static void main(String[] args) {
		//创建真实角色
		RealSubject rs=new RealSubject();
		//通过代理类实例化抽象角色
		Subject sub=new ProxySubject(rs);
		
		sub.request();
	}
}
