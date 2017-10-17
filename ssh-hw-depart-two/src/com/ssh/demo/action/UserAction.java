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
		//����õ�users����request����
		request.put("users", users);
		return "list";
	}

	private User model;
	
	@Override
	public User getModel() {
		return model;
	}
	//--------------save ����---------------------
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
	//--------------save ����---------------------
	
	//--------------delete ����---------------------
	
	public String delete(){
		userService.delete(id);
		return SUCCESS;
	}
	//--------------delete ����---------------------
	
	//---------------update ����--------------------
	public String input(){
		return "input";
	}
	
	public void prepareInput(){
		if(id !=null){
			model=userService.get(id);
		}
	}
	
	//---------------update ����--------------------
	
	@Override
	public void prepare() throws Exception {
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request = arg0;
	}

}
