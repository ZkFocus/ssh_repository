package com.struts2.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

public class WebAction4 implements ServletRequestAware, ServletResponseAware, ServletContextAware {
	private ServletRequest request;
	private ServletResponse response;
	private ServletContext context;

	@Override
	public void setServletRequest(HttpServletRequest httpServletRequest) {
		request = httpServletRequest;
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		response = httpServletResponse;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		context = servletContext;
	}

	public String execute() throws Exception {
		// 验证表单数据是否提交过来了
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "----" + password);
		request.setAttribute("username", username);
		return "success";
	}

}
