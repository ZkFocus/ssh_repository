package com.spring.in.action.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CashierService {

	@Autowired
	private BookService bookService;
	
	@Transactional
	public void checkout(String username, List<String> isbns) {
		for(String isbn:isbns){
			bookService.purchase(username, isbn);
		}
	}
}
