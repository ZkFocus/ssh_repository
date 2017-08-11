package com.mybatis.demo.dao;

import org.apache.ibatis.annotations.Select;

import com.mybatis.demo.entity.User;

public interface UserManagerAnnotation {

	@Select("select * from user where id = #{id} ")
	public User getUserById(Integer id);
}
