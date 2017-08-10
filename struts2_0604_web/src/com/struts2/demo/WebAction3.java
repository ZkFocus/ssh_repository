package com.struts2.demo;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class WebAction3  {

	public String execute() throws Exception {
		ActionContext ac = ActionContext.getContext();
		ServletRequest request = (ServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
		/*ServletResponse response = (ServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
		ServletContext context = (ServletContext) ac.get(ServletActionContext.SERVLET_CONTEXT);*/
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "............" + password);
		request.setAttribute("username", username);
		return "success";
	}
}
