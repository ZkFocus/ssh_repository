package com.hp.demo.introducation.factory;

import com.hp.demo.introducation.traditional.CHello;
import com.hp.demo.introducation.traditional.IHello;

public class BeanFactory {

	//�򵥹���ģʽ
	public static IHello getInstance(){
		 return new CHello();
	}
}
