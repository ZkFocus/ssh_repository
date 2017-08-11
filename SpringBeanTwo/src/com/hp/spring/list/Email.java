package com.hp.spring.list;

public class Email {

	private String address;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Email [address=" + address + "]";
	}
	
	
}
