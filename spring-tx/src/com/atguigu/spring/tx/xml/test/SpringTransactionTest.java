package com.atguigu.spring.tx.xml.test;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.spring.tx.xml.service.BookShopService;
import com.atguigu.spring.tx.xml.service.CashierService;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopService bookShopService = null;
	private CashierService cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopService = ctx.getBean(BookShopService.class);
		cashier = ctx.getBean(CashierService.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashier.checkout("tom", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	
}
