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
	//set��trim���ʹ��
	public int updateUserBySetAndTrim(User user);
	//foreach  ����Ϊlist
	public List<UserCustom> selectUserByForEachList(UserQueryVo userQueryVo);
	//bind
	public List<User> findUserByUname(User user);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<User> getUser(@Param("uname")String uname);
	public User getUserMap(Map map);
	//ֻ�ܲ�һ������
	public Map<Integer, User> getUserMapDX(String uname);
	//��ѯ��������
	@MapKey("id")
	public Map<Integer, User> getUserMapList(String uname);
	//����ID��ѯ����
	public String getUserByid(Integer id);
}
