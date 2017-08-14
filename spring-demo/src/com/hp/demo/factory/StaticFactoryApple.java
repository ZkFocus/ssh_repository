package com.hp.demo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 直接调用一个类的静态方法就返回一个bean实例
 * 
 * @author Administrator
 *
 */
public class StaticFactoryApple {

	private static Map<String, Apple> aMap = new HashMap<>();
	static {
		aMap.put("Red", new Apple("Red", 10));
		aMap.put("Green", new Apple("Green", 5));
	}

	public static Apple getApple(String color) {

		return aMap.get(color);

	}

}
