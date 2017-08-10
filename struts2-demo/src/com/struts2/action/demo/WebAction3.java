package com.struts2.action.demo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction3 extends ActionSupport{

	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	public WebAction3(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		application=session.getServletContext();
	}
	public String execute(){
		request.setAttribute("r_key", "r_value_3");
		session.setAttribute("s_key", "s_value_3");
		application.setAttribute("a_key", "a_value_3");
		return SUCCESS;
	}
}
