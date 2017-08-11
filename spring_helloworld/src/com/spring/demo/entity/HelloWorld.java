package com.spring.demo.entity;

public class HelloWorld {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + name + "]";
	}

	public HelloWorld(String name) {
		super();
		this.name = name;
		System.out.println("xiaowang");
	}

	public HelloWorld() {
		super();
		System.out.println("-----");
	}

	
}
