package com.hp.demo.factory;

import java.util.HashMap;
import java.util.Map;

public class InstanceAppleFactory {

	private static Map<String, Apple> aMap = null;

	public InstanceAppleFactory() {
		aMap = new HashMap<>();
		aMap.put("Red", new Apple("Red", 10));
		aMap.put("Green", new Apple("Green", 5));
	}

	public Apple getApple(String color) {

		return aMap.get(color);

	}
}
