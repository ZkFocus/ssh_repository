package com.hp.demo.entity;

import java.util.List;

public class User {
	
	private String name;
	
	private List<Apple> apples;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Apple> getApples() {
		return apples;
	}

	public void setApples(List<Apple> apples) {
		this.apples = apples;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", apples=" + apples + "]";
	}
	
	

}
