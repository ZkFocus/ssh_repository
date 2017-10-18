package com.spring.smvc.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smvc.demo.controller.UserController;

@Service
public class UserService {

	/*@Autowired
	private UserController controller;*/
	
	public UserService() {
		System.out.println("UserService init finished.......");
	}

	
	
}
