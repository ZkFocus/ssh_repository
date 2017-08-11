package com.hp.entity.cycle;

public class HelloWorld {
	
	private String name;

	

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "HelloWorld [name=" + name + "]";
	}

	
	public void a(){
		System.out.println("init.......");
	}
	public void b(){
		System.out.println("destroy......");
	}
	
	
}
