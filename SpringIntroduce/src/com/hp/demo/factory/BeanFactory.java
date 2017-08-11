package com.hp.demo.factory;

import com.hp.demo.CHello;
import com.hp.demo.EHello;
import com.hp.demo.IHello;

public class BeanFactory {
	
	public static IHello  getInstance(){
		return new EHello();
	}

}
