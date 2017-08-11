package com.ssh.demo.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.demo.service.UserService;

public class UserAction extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private Map<String, Object> request;

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

	/**
	 * 查看所有人员
	 * 
	 * @return
	 */
	public String list() {
		request.put("users", userService.getAllUser());
		return "list";
	}

}
