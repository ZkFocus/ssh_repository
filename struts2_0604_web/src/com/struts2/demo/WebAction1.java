package com.struts2.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class WebAction1 {

	private String username;
	private String password;

	public String execute() {

		if ("admin".equals(username) && "admin".equals(password)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			/**
			 *  ServletActionContext继承了ActionContext,它提供了直接与Servlet相关对象访问的功能
			 *  ActionContext是Action执行时的上下文,上下文可以看作为容器,它存放的是Action在执行时用到的对象. 
			 *  查看源码得知actioncontext是线程安全的
			 *  （ThreadLocal类为每一个线程都维护了自己独有的变量拷贝。每个线程都拥有了自己独立的一个变量）
			 *  
			 */
			//线程安全要求每个线程都是独立进行的，所以HttpServletRequest得创建也应该是独立的
			HttpServletRequest request = ServletActionContext.getRequest();
			System.out.println(request.getParameter("username")+"----");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";
		} else {
			return "error";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
