package com.easyui.ssh.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;

import com.alibaba.fastjson.JSON;
import com.easyui.ssh.entity.User;
import com.easyui.ssh.service.UserService;
import com.easyui.ssh.util.Response;

public class UserAction implements RequestAware{
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	private ServletRequest request;
	@Override
	public void setRequest(Map<String, Object> map) {
		request = (ServletRequest) map.get(StrutsStatics.HTTP_REQUEST);
	}
	
	public void register() throws Exception {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel=request.getParameter("tel");
		String message=request.getParameter("message");
		User user=new User(name,email,tel,message);
		Response resp = new Response();
		try {
			userService.saveOrUpdate(user);
			resp.setSuccess(true);
			resp.setMsg("ע�ᣡ");
		} catch (Exception e) {
			resp.setMsg(e.getMessage());
		}
		writeJson(resp);
	}
	
	public void writeJson(Object object) {
		try {
			String json = JSON.toJSONString(object);
			System.out.println(json);
			HttpServletResponse response=ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
