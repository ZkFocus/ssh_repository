package com.hp.spring.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceFactory {

	private static Map<String,Apple> aMap=null;
	public InstanceFactory(){
		aMap =new HashMap<>();
		aMap.put("Red", new Apple("Red", 10));
		aMap.put("Green", new Apple("Green", 8));
		
	}
	public Apple getApple(String color){
		return aMap.get(color);
	}
}
