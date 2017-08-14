package com.spring.in.action.repository;

import org.springframework.jdbc.core.JdbcTemplate;

public class BookRepository {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
