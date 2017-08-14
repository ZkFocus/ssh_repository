package com.spring.in.action.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.in.action.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional
	public void purchase(String username, String isbn) {
		int price = bookRepository.findBookPriceByIsbn(isbn);
		bookRepository.updateBookStock(isbn);
		bookRepository.updateUserAccount(username, price);
	}
}
