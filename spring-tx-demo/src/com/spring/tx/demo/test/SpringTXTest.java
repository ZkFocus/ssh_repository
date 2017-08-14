package com.spring.tx.demo.test;

import java.sql.SQLException;
import java.util.Arrays;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.tx.demo.repository.BookRepository;
import com.spring.tx.demo.service.BookService;
import com.spring.tx.demo.service.CashierService;

public class SpringTXTest {
	
	private ApplicationContext ac=null;
	private DataSource dataSource=null;
	private BookService bookService=null;
	private CashierService cashierService=null;
	
	{
		ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource=ac.getBean(DataSource.class);
		bookService=ac.getBean(BookService.class);
		cashierService=ac.getBean(CashierService.class);
	}
	
	@Test
	public void test() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	
	@Test
	public void testBook(){
		bookService.purchase("tom", "1002");
	}
	
	@Test
	public void testCashier(){
		cashierService.checkout("tom", Arrays.asList("1001","1002"));
	}
	
}
