package com.struts2.action.demo;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private static final long serialVersionUID = 1L;
	
	private User user=new User();
	
	public String add() {
		System.out.println("Ãû×Ö£º"+ user.getName()+ "==="+"ÄêÁä£º"+user.getAge());
		return SUCCESS;
	}
	public String del() {
		return SUCCESS;
	}
	@Override
	public User getModel() {
		
		return user;
	}
}
