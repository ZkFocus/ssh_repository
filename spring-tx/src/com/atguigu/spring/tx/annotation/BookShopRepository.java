package com.atguigu.spring.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopRepository  {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int findBookPriceByIsbn(String isbn) {
		String sql = "SELECT price FROM book WHERE isbn = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
	}

	public void updateBookStock(String isbn) {
		//�����Ŀ���Ƿ��㹻, ������, ���׳��쳣
		String sql2 = "SELECT stock FROM book WHERE isbn = ?";
		int stock = jdbcTemplate.queryForObject(sql2, Integer.class, isbn);
		if(stock == 0){
			throw new BookStockException("��治��!");
		}
		
		String sql = "UPDATE book SET stock = stock -1 WHERE isbn = ?";
		jdbcTemplate.update(sql, isbn);
	}

	public void updateUserAccount(String username, int price) {
		//��֤����Ƿ��㹻, ������, ���׳��쳣
		String sql2 = "SELECT balance FROM account WHERE username = ?";
		int balance = jdbcTemplate.queryForObject(sql2, Integer.class, username);
		if(balance < price){
			throw new UserAccountException("����!");
		}
		
		String sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
		jdbcTemplate.update(sql, price, username);
	}

}
