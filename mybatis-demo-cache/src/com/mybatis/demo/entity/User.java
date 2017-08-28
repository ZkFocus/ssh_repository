package com.mybatis.demo.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String telNum;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telNum=" + telNum + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public User(String name, String telNum) {
		super();
		this.name = name;
		this.telNum = telNum;
	}
	public User() {
		super();
	}
	public User(int id, String name, String telNum) {
		super();
		this.id = id;
		this.name = name;
		this.telNum = telNum;
	}
	
	
	
}
