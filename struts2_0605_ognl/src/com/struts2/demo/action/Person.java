package com.struts2.demo.action;

public class Person {
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String sayHello(){
		return "hello ognl";
	}
	
}
