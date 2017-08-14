package com.spring.tx.demo.service;

import com.spring.tx.demo.repository.BookRepository;

public class BookService {

	private BookRepository bookRepository;
	
	public void setBookRepository(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void purchase(String userName,String isbn){
		int price = bookRepository.findPriceByISBN(isbn);
		
		bookRepository.updateStock(isbn);
		
		bookRepository.updateAccountPrice(userName, price);
	}
}
