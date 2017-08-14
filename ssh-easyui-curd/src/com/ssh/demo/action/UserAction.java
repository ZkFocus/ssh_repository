package com.ssh.demo.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;

import com.ssh.demo.entity.User;
import com.ssh.demo.service.UserService;

public class UserAction implements RequestAware {
	private int page;
	private int rows;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public ServletRequest getRequest() {
		return request;
	}

	public void setRequest(ServletRequest request) {
		this.request = request;
	}

	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	private ServletRequest request;

	@Override
	public void setRequest(Map<String, Object> map) {
		request = (ServletRequest) map.get(StrutsStatics.HTTP_REQUEST);
	}

	public void list() {
		try {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");

			Map<String, String> map = new HashMap<String, String>();

			map.put("name", name);
			map.put("tel", tel);

			String json_list = userService.getPageJSON(page, rows, map);

			HttpServletResponse response = ServletActionContext.getResponse();

			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(json_list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert() throws IOException {
		String type = request.getParameter("type");
		String msg = "";
		if (type.equals("add")) {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			User user = new User(name, tel, address);
			userService.saveOrUpdate(user);
			msg = "{'success':true,'message':'保存成功'}";

			HttpServletResponse response = ServletActionContext.getResponse();

			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(msg);
		}
		if(type.equals("edit")){
			String id=request.getParameter("id");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			User user = new User(Integer.valueOf(id),name, tel, address);
			userService.saveOrUpdate(user);
			msg = "{'success':true,'message':'修改成功'}";

			HttpServletResponse response = ServletActionContext.getResponse();

			response.setCharacterEncoding("UTF-8");

			response.getWriter().write(msg);
		}
	}
	
	public void delete() throws IOException{
		String id=request.getParameter("id");
		userService.del(Integer.valueOf(id));
		String msg = "";
		msg = "{'success':true,'message':'删除成功'}";

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setCharacterEncoding("UTF-8");

		response.getWriter().write(msg);
	}

}
