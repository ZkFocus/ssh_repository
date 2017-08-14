package com.hp.demo.entity;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
	
	private String name;
	
	private Map<String,Apple> apples=new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Apple> getApples() {
		return apples;
	}

	public void setApples(Map<String, Apple> apples) {
		this.apples = apples;
	}

	@Override
	public String toString() {
		return "UserMap [name=" + name + ", apples=" + apples + "]";
	}
	
	

}
