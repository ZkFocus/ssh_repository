package com.ssh.demo.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.demo.entity.User;
import com.ssh.demo.service.UserService;

public class UserAction extends ActionSupport implements RequestAware,ModelDriven<User>,Preparable  {
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Map<String, Object> request;
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
			request=arg0;
	}
	public String list(){
		request.put("users", userService.getAll());
		return "list";
	}
	
	private User model;
	
	@Override
	public User getModel() {
		
		return model;
	}
	
	public String input(){
		return "input";
	}
	public void prepareInput(){
		
		if (id != null) {
			model = userService.get(id);
		}
	}

	public String save(){
		userService.saveOrUpdate(model);
		return SUCCESS;
	}
	/**
	 * 执行save方法之前 先执行该方法 用于判断model的获取方式
	 */
	public void prepareSave(){
		
		if(id!=null){
			model =userService.get(id);
		}else{
			model=new User();
		}
	}
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String delete(){
		userService.delete(id);
		return SUCCESS;
	}
	@Override
	public void prepare() throws Exception {
	}
	
}
