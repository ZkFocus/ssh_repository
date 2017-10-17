package com.ssh.demo.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.demo.entity.User;
import com.ssh.demo.service.UserService;

public class UserAction extends ActionSupport implements RequestAware,ModelDriven<User>,Preparable{

	private UserService userService;
	
	private Integer id;
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private Map<String,Object> request;
	
	
	
	
	
	public String list(){
		List<User> users=userService.getAllUser();
		//将获得的users放入request域中
		request.put("users", users);
		return "list";
	}

	private User model;
	
	@Override
	public User getModel() {
		return model;
	}
	//--------------save 操作---------------------
	public String save(){
		userService.saveOrUpdate(model);
		return SUCCESS;
	}
	public void prepareSave(){
		if(id ==null){
			model =new User();
		}else{
			model =userService.get(id);
		}
	}
	//--------------save 操作---------------------
	
	//--------------delete 操作---------------------
	
	public String delete(){
		userService.delete(id);
		return SUCCESS;
	}
	//--------------delete 操作---------------------
	
	//---------------update 操作--------------------
	public String input(){
		return "input";
	}
	
	public void prepareInput(){
		if(id !=null){
			model=userService.get(id);
		}
	}
	
	//---------------update 操作--------------------
	
	@Override
	public void prepare() throws Exception {
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
