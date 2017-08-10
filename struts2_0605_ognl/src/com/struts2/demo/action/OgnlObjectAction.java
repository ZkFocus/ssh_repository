package com.struts2.demo.action;

public class OgnlObjectAction {
	private User user;

	public String execute() {
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
