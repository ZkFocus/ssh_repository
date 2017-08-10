package com.struts2.action.demo;

import com.opensymphony.xwork2.ActionSupport;

public class DynamicResultAction extends ActionSupport{
	private int type;
	private String view;
	public String execute(){
		if(type==1){
			view="/hello1.jsp";
		}else if(type==2){
			view="/hello2.jsp";
		}else{
			view="/hello3.jsp";
		}
		return SUCCESS;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
	
}
