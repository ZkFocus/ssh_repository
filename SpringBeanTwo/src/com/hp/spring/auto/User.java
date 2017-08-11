package com.hp.spring.auto;

public class User {
	
	private String name;
	
	private Address address;
	
	private Apple apple;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", address=" + address + ", apple=" + apple + "]";
	}
	
	

}
