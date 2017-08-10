package com.struts2.action.demo;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WebAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Map request;
	private Map session;
	private Map application;
	
	public WebAction(){
		request=(Map) ActionContext.getContext().get("request");
		session=ActionContext.getContext().getSession();
		application=ActionContext.getContext().getApplication();
	}

	public String execute(){
		request.put("r_key", "r_value");
		session.put("s_key", "s_value");
		application.put("a_key", "a_value");
		return SUCCESS;
	}
}
