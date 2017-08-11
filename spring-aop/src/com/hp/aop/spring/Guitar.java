package com.hp.aop.spring;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Performance{

	@Override
	public void perform() {
		System.out.println("Guitar...Guitar...Guitar");
//		throw new NullPointerException();
		
	}

}
