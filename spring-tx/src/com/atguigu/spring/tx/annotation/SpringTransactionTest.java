package com.atguigu.spring.tx.annotation;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private BookShopRepository bookShopRepository = null;
	private BookShopService bookShopService = null;
	private CashierService cashierService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopRepository = ctx.getBean(BookShopRepository.class);
		bookShopService = ctx.getBean(BookShopService.class);
		cashierService = ctx.getBean(CashierService.class);
	}
	
	@Test
	public void testTransactionlPropagation(){
		cashierService.checkout("AA", Arrays.asList("1001", "1002"));
	}
	
	@Test
	public void testBookShopService(){
		bookShopService.purchase("AA", "1001");
	}
	
	@Test
	public void testBookShopDaoUpdateUserAccount(){
		bookShopRepository.updateUserAccount("AA", 200);
	}
	
	@Test
	public void testBookShopDaoUpdateBookStock(){
		bookShopRepository.updateBookStock("1001");
	}
	
	@Test
	public void testBookShopDaoFindPriceByIsbn() {
		System.out.println(bookShopRepository.findBookPriceByIsbn("1001"));
	}

}
