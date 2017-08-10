package com.struts2.action.demo;

import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport{
	private Person person;
	public String execute(){
		this.addFieldError("fielderror", "name is error");
		return SUCCESS;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
}
