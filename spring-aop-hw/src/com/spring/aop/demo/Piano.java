package com.spring.aop.demo;

import org.springframework.stereotype.Component;
/**
 * component ��� 
 * ��֪spring���� ����Ϊһ�����
	spring�����Ὣ@Componentע��������������
 * @author mbdn
 *
 */
@Component
public class Piano implements Performance{

	@Override
	public void perform() {
		System.out.println("���ٱ���......");
//		throw new NullPointerException();
	}

	
}
