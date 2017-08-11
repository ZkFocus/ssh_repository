package com.hp.spring.factory;

import java.util.HashMap;
import java.util.Map;


public class StaticFactory {
	
	private static Map<String, Apple> aMap=new HashMap<>();
	static {
		aMap.put("Red", new Apple("Red",10));
		aMap.put("Green", new Apple("Green",8));
		
	}
	
	public static Apple getApple(String color){
		return aMap.get(color);
	}
	
	
}
