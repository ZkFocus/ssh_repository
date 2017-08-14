package com.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springmvc.entity.User;

@Controller
public class TestFlash {

	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user,RedirectAttributes rAttributes){
		System.out.println(user);
		rAttributes.addFlashAttribute("user", user);
		return "redirect:/home";
	}
}
