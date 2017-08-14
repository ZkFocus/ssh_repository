package com.spring.in.action.test;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.in.action.config.DataSourceConfig;
import com.spring.in.action.entity.Book;
import com.spring.in.action.repository.BookRepository;
import com.spring.in.action.service.BookService;
import com.spring.in.action.service.CashierService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataSourceConfig.class)
public class SpringHibernateTest {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private CashierService cashierService;
	
	@Test
	@Transactional
	public void test(){
		int i=bookRepository.test();
		System.out.println(i);
		/*
		List<Book> books=bookRepository.findAll();
		System.out.println(books);*/
		
//		bookRepository.testAccount("tom",20);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testTransactional(){
		bookService.purchase("tom", "1001");
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testCashier(){
		cashierService.checkout("tom", Arrays.asList("1001","1002"));
	}
}
