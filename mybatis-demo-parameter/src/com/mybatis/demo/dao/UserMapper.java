package com.mybatis.demo.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.mybatis.demo.entity.User;

public interface UserMapper {
	
	/**
	 * ���������Ĵ���
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public void deleteUserById(Integer id);
	
	/**
	 * ������Ĵ���
	 */
	public User getUserByIdAndName(@Param("id")Integer id,@Param("name")String name);
	
	public User getUserByMap(Map<String, Object> map);
	
	public List<User> getUserList(String name);
	
	public Map<String,Object> getUserSingleMap(Integer id);
	
	/**
	 * @MapKey("id") ���ؽ������User�����Ӧ���ֶ� ָ������key
	 * @param name
	 * @return
	 */
	@MapKey("id")
	public Map<Integer,User> getUserManyMap(String name);
	
	
	
	
}
