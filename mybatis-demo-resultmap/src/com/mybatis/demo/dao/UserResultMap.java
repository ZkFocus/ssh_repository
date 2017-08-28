package com.mybatis.demo.dao;

import com.mybatis.demo.entity.User;

public interface UserResultMap {
	
	public User getUserById(Integer id);
	
	public User getUserAndAddr(Integer id);
	
	public User getUserByIdAssociation(Integer id);
}
