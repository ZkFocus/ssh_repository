package com.struts2.action.demo;

public class User {

	private Address address;
	private int age;
	private String name;
	
	public Address getAddress() {
		return address;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String sayHello(){
		return "hello ognl";
	}
	
}
