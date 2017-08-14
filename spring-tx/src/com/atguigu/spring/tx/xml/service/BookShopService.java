package com.atguigu.spring.tx.xml.service;

import com.atguigu.spring.tx.xml.repository.BookShopRepository;


public class BookShopService  {

	private BookShopRepository bookShopRepository;
	
	public void setBookShopRepository(BookShopRepository bookShopRepository) {
		this.bookShopRepository = bookShopRepository;
	}
	
	public void purchase(String username, String isbn) {
		
		
		//1. ��ȡ��ĵ���
		int price = bookShopRepository.findBookPriceByIsbn(isbn);
		
		//2. �������Ŀ��
		bookShopRepository.updateBookStock(isbn);
		
		//3. �����û����
		bookShopRepository.updateUserAccount(username, price);
	}

}
