package com.spring.in.action.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.in.action.entity.Title;

@Repository
public class TitleRepository {

	@Autowired
	private JdbcOperations jdbcOperations;
	public Title get(Integer id){
		String sql = "SELECT id, message , created_at as createDate,latitude,longitude FROM title WHERE id = ?";
		RowMapper<Title> rowMapper = new BeanPropertyRowMapper<>(Title.class);
		Title title = jdbcOperations.queryForObject(sql, rowMapper, id);
		return title;
	}
}
