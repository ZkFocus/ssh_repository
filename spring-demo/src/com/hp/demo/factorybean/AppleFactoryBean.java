package com.hp.demo.factorybean;

import org.springframework.beans.factory.FactoryBean;

public class AppleFactoryBean implements FactoryBean<Apple>{
	
	private String color;
	
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public Apple getObject() throws Exception {
		return new Apple(color,15);
	}

	@Override
	public Class<?> getObjectType() {
		return Apple.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
