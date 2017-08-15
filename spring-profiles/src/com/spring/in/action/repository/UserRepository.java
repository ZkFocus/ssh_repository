package com.spring.in.action.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.in.action.entity.User;

@Repository
public class UserRepository{
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	public User get(Integer id){
		String sql = "SELECT id, name , tel FROM user WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		User employee = jdbcOperations.queryForObject(sql, rowMapper, id);
		return employee;
	}
}