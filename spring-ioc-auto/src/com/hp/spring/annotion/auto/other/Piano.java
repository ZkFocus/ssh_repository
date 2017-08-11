package com.hp.spring.annotion.auto.other;

import org.springframework.stereotype.Component;

import com.hp.spring.annotion.auto.Performance;

@Component
public class Piano implements Performance{

	@Override
	public void perform() {
		System.out.println("piano....");
		
	}

	
}
