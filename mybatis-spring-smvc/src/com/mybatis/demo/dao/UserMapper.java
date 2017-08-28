package com.mybatis.demo.dao;

import java.util.List;
import java.util.Map;

import com.mybatis.demo.entity.User;

public interface UserMapper {
	public User getUserById(int id);
	
	public List<User> getUsers(Map  map);
	
	public Long getTotalUser();
	
	public int updateUser(User user);
	
	public int addUser(User user);
	
	public int deleteUser(Integer id);
}
