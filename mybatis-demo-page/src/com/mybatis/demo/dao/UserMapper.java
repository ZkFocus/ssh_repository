package com.mybatis.demo.dao;

import java.util.List;

import com.mybatis.demo.entity.User;

public interface UserMapper {
	
	public User getUserById(Integer id);
	
	public List<User> getUsers();
	
}
