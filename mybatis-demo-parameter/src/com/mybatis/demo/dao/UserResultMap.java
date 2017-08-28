package com.mybatis.demo.dao;

import com.mybatis.demo.entity.User;

public interface UserResultMap {
	
	/**
	 * 单个参数的处理
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id);
	
	
	
	
}
