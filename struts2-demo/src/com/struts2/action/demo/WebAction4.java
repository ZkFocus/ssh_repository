package com.struts2.action.demo;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction4 extends ActionSupport implements ServletRequestAware{
	private HttpServletRequest request;
	private HttpSession session;
	private ServletContext application;
	public String execute(){
		request.setAttribute("r_key", "r_value_4");
		session.setAttribute("s_key", "s_value_4");
		application.setAttribute("a_key", "a_value_4");
		return SUCCESS;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
		session=request.getSession();
		application=session.getServletContext();
	}
}
