package com.struts2.demo;

import com.opensymphony.xwork2.ModelDriven;

public class Parameter_ModelDriven implements ModelDriven<User>{

	private User user=new User();
	
	public String add(){
		System.out.println("用户名："+user.getName()+"...ModelDriven");
		System.out.println("年龄："+user.getAge()+"...ModelDriven");
		return "success";
	}
	
	@Override
	public User getModel() {

		return user;
	}

}
