package com.mybatis.demo.entity;

public class User {
	
	private Integer id;
	private String name;
	private String telNum;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telNum=" + telNum + "]";
	}
	public User(Integer id, String name, String telNum) {
		super();
		this.id = id;
		this.name = name;
		this.telNum = telNum;
	}
	public User() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	
	
}
