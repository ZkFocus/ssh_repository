package com.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.entity.User;

@Controller
public class TestGetPostMapping {
//	@RequestMapping(value="userList",method=RequestMethod.GET)
	@GetMapping("userList")
	public String testSendModelToJsp(Model model){
		List<User> userList=new ArrayList(){{
			add(new User("AA","111","136890"));
			add(new User("BB","222","136890"));
			add(new User("CC","333","136890"));
			add(new User("DD","444","136890"));
		}};
		model.addAttribute("userList", userList);
		return "list";
	}
	
//	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	@PostMapping("testPostMapping")
	public String testRegister(User user){
		System.out.println("testPostMapping:"+user);
		return "success";
	}
	
}
