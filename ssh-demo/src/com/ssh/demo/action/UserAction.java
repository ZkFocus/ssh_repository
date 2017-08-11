package com.ssh.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.ssh.demo.entity.User;
import com.ssh.demo.service.UserService;

import net.sf.json.JSONObject;

public class UserAction extends ActionSupport implements ModelDriven<User>,Preparable  {
	
	private static final long serialVersionUID = 1L;
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	 private JSONObject resultObj ; 
	 
	 
	 
	public JSONObject getResultObj() {
		return resultObj;
	}

	public void setResultObj(JSONObject resultObj) {
		this.resultObj = resultObj;
	}

	public String list(){
		List<Map<String, Object>> all = new ArrayList<Map<String, Object>>();  
		List<User> userList=userService.getAll();
		for(User u:userList){
			Map<String, Object> map = new HashMap<String, Object>(); 
			map.put("ID", u.getId());
			map.put("name", u.getName());
			map.put("tel", u.getTel());
			map.put("birth", u.getBirth());
			all.add(map);
		}
		Map<String, Object> json = new HashMap<String, Object>();     
        json.put("total", all.size());
        json.put("rows", all);    
		resultObj =JSONObject.fromObject(json);
		System.out.println(resultObj);
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
