package com.hp.spring.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

	private String name;
	
	private Map<String, Email> emails=new HashMap<String, Email>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Email> getEmails() {
		return emails;
	}

	public void setEmails(Map<String, Email> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emails=" + emails + "]";
	}

	
	
	
}
