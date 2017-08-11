package com.mybatis.demo.entity;

import org.apache.ibatis.type.Alias;

public class User {

	private Integer id;
	private String name;
	private String telNum;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", telNum=" + telNum + "]";
	}
	
	
}
