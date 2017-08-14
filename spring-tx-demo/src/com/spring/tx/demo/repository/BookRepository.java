package com.spring.tx.demo.repository;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.tx.demo.exceptions.BookStockException;
import com.spring.tx.demo.exceptions.UserAccountException;

public class BookRepository {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int findPriceByISBN(String isbn){
		String sql="select price from book where isbn = ?";
		int price=jdbcTemplate.queryForObject(sql, Integer.class,isbn);
		return price;
	}
	
	public void updateStock(String isbn){
		String sql2="select stock from book where isbn = ? ";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock == 0){
			throw new BookStockException("¿â´æ²»×ã");
		}
		String sql="update book set stock = stock -1 where isbn =?";
		jdbcTemplate.update(sql,isbn);
	}
	public void updateAccountPrice(String username,int price){
		String sql ="select balance from account where username = ?";
		int balance = jdbcTemplate.queryForObject(sql, Integer.class,username);
		if(balance < price){
			throw new UserAccountException("Óà¶î²»×ã");
		}
		String sql2 = "update account set balance = balance -? where username = ?";
		jdbcTemplate.update(sql2, price,username);
	}
}
