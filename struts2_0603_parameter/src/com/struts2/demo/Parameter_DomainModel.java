package com.struts2.demo;

public class Parameter_DomainModel {
	private User user;
	public String add(){
		System.out.println("�û�����"+user.getName());
		System.out.println("���䣺"+user.getAge());
		return "success";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
