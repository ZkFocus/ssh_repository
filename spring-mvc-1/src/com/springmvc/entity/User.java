package com.springmvc.entity;

public class User {

	private String userName;
	private String tel;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", tel=" + tel + ", password=" + password + "]";
	}
	public User(String userName, String tel, String password) {
		super();
		this.userName = userName;
		this.tel = tel;
		this.password = password;
	}
	public User() {
		super();
	}
	
	
	
}
