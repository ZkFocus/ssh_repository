package com.hp.spring.ref;

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
