package com.struts2.action.demo;

import com.opensymphony.xwork2.ActionSupport;

public class OgnlAction extends ActionSupport{

	private User user;
	public String execute(){
		System.out.println(user.getAddress().getCity());
		return SUCCESS;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String sayHello(){
		return "hello from action";
	}
}
