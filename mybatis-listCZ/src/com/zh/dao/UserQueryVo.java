package com.zh.dao;

import java.util.List;

public class UserQueryVo {
	private List<Integer> lid;
	public List<Integer> getLid() {
		return lid;
	}
	public void setLid(List<Integer> lid) {
		this.lid = lid;
	}
	private UserCustom userCustom;

	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
