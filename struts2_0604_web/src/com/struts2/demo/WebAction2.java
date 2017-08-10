package com.struts2.demo;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;

public class WebAction2 implements RequestAware {

	private ServletRequest request;
/*	private ServletResponse response;
	private ServletContext context;*/

	@Override
	public void setRequest(Map<String, Object> map) {
		request = (ServletRequest) map.get(StrutsStatics.HTTP_REQUEST);
	/*	response = (ServletResponse) map.get(StrutsStatics.HTTP_RESPONSE);
		context = (ServletContext) map.get(StrutsStatics.SERVLET_CONTEXT);*/
	}

	public String execute() throws Exception {
		// 验证表单数据是否提交过来了
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username + "----" + password);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		return "success";
	}
}
