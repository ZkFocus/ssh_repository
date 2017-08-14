package com.hp.demo.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ֱ�ӵ���һ����ľ�̬�����ͷ���һ��beanʵ��
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
