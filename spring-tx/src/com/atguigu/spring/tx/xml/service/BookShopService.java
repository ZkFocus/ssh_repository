package com.atguigu.spring.tx.xml.service;

import com.atguigu.spring.tx.xml.repository.BookShopRepository;


public class BookShopService  {

	private BookShopRepository bookShopRepository;
	
	public void setBookShopRepository(BookShopRepository bookShopRepository) {
		this.bookShopRepository = bookShopRepository;
	}
	
	public void purchase(String username, String isbn) {
		
		
		//1. 获取书的单价
		int price = bookShopRepository.findBookPriceByIsbn(isbn);
		
		//2. 更新数的库存
		bookShopRepository.updateBookStock(isbn);
		
		//3. 更新用户余额
		bookShopRepository.updateUserAccount(username, price);
	}

}
