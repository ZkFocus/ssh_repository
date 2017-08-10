package com.struts2.demo;

public class ParameterAction {

	private String name;
	private int age;
	public String add(){
		System.out.println("ĞÕÃû£º"+name+"	ÄêÁä£º"+age);
		return "success";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
