package com.hp.spring.list;

import java.util.List;

public class User {

	private String name;
	
	private List<Email> email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Email> getEmail() {
		return email;
	}

	public void setEmail(List<Email> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + "]";
	}
	
	
}
