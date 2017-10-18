package com.spring.smvc.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.smvc.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	public UserController() {
		System.out.println("UserController init ......");
	}
	@RequestMapping("test")
	public String test(){
		System.out.println(userService);
		return "";
	}

	
}
