package com.hp.proxy.statiz;

public class ClientTest {
	
	public static void main(String[] args) {
		//������ʵ��ɫ
		RealSubject rs=new RealSubject();
		//ͨ��������ʵ���������ɫ
		Subject sub=new ProxySubject(rs);
		
		sub.request();
	}
}
