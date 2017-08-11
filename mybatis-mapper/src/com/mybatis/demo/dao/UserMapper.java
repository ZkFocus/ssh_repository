package com.mybatis.demo.dao;

import com.mybatis.demo.entity.User;

public interface UserMapper {

	public User getUserById(Integer id);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(Integer id);
}
