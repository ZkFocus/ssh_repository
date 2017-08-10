package com.struts2.action.demo;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class WebAction2 extends ActionSupport implements RequestAware,SessionAware,ApplicationAware{
	private Map<String,Object> request;
	private Map<String,Object> session;
	private Map<String,Object> application;
	public String execute(){
		request.put("r_key", "r_value_2");
		session.put("s_key", "s_value_2");
		application.put("a_key", "a_value_2");
		return SUCCESS;
	}
	
	@Override
	public void setApplication(Map<String, Object> application) {
		this.application=application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}

}
