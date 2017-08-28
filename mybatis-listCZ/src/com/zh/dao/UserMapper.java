package com.zh.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.zh.model.User;

public interface UserMapper {
	//if
	public List<User> getUserif(User user);
	//ifs
	public List<UserCustom> getUserList(UserQueryVo userQueryVo);
	//choose, when, otherwise
	public List<User> getUserCWO(User user);
	//trim 
	public List<User> getUserTrim(User user);
	//set
	public int updateUserBySet(User user);
	//set和trim配合使用
	public int updateUserBySetAndTrim(User user);
	//foreach  参数为list
	public List<UserCustom> selectUserByForEachList(UserQueryVo userQueryVo);
	//bind
	public List<User> findUserByUname(User user);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<User> getUser(@Param("uname")String uname);
	public User getUserMap(Map map);
	//只能查一条数据
	public Map<Integer, User> getUserMapDX(String uname);
	//查询多条数据
	@MapKey("id")
	public Map<Integer, User> getUserMapList(String uname);
	//根据ID查询单列
	public String getUserByid(Integer id);
}
