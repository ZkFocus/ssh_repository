package com.hp.demo.entity;

public class HelloWorld {
	 private String name;
	 public void setName(String name) {
		this.name = name;
	}
	 
	 public void sayHello(){
		 System.out.println("Hello:"+name);
	 }

	public HelloWorld(String name) {
		this.name = name;
	}

	public HelloWorld() {
		System.out.println("init----------");
	}

	 
	 
}
