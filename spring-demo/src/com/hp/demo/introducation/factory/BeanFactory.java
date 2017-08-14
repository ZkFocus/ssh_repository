package com.hp.demo.introducation.factory;

import com.hp.demo.introducation.traditional.CHello;
import com.hp.demo.introducation.traditional.IHello;

public class BeanFactory {

	//简单工厂模式
	public static IHello getInstance(){
		 return new CHello();
	}
}
