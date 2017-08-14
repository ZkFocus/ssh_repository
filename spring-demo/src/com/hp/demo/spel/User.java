package com.hp.demo.spel;

public class User {
	private String  name;
	
	private String home;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", home=" + home + "]";
	}

	
	
}
