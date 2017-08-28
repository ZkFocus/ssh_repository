package com.mybatis.demo.entity;

import java.io.Serializable;

public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String telNum;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telNum=" + telNum + "]";
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
