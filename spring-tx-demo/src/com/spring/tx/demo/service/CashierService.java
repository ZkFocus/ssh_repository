package com.spring.tx.demo.service;

import java.util.List;

public class CashierService {
	
	BookService bookService;
	
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	public void checkout(String userName,List<String> isbns){
		for(String isbn:isbns){
			bookService.purchase(userName, isbn);
		}
	}

}
