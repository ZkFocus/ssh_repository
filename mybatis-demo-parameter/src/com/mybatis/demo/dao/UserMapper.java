package com.mybatis.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mybatis.demo.entity.User;

public interface UserMapper {
	
	/**
	 * 单个参数的处理
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(Integer id);
	
	/**
	 * 多参数的处理
	 */
	public User getUserByIdAndName(@Param("id")Integer id,@Param("name")String name);
	
	public User getUserByMap(Map<String, Object> map);
	
	public List<User> getUserList(String name);
	
	public Map<String,Object> getUserSingleMap(Integer id);
	
	/**
	 * @MapKey("id") 返回结果集中User对象对应的字段 指定属性key
	 * @param name
	 * @return
	 */
	@MapKey("id")
	public Map<Integer,User> getUserManyMap(String name);
	
	
	
	
}
