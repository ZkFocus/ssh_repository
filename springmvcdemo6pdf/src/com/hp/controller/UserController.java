package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.hp.bean.User;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam(value="username") String name,
			@RequestParam(value="password") String password,Model mode){
		
		System.err.println("name"+name);
		if (name.isEmpty()) {
			mode.addAttribute("message", "用户名为空");
			return "error";
		}
		if (password.isEmpty()) {
			mode.addAttribute("message", "密码为空");
			return "error";
		}
		if (name=="123" && password=="456") {
			mode.addAttribute("message", "登录成功");
			return "success";
		}else{
			mode.addAttribute("message", "用户名或密码错误！");
			return "error";
		}
		
	}

	@RequestMapping(value="/login1",method=RequestMethod.POST)
	public String login1(User user,Model mode){
		String name=user.getUsername();
		String password=user.getPassword();
		System.err.println("name"+name);
		if (name.isEmpty()) {
			mode.addAttribute("message", "用户名为空");
			return "error";
		}
		if (password.isEmpty()) {
			mode.addAttribute("message", "密码为空");
			return "error";
		}
		if (name.equals("123") && password.equals("456")) {
			mode.addAttribute("message", "登录成功");
			//重定向控制器
			return "redirect:/memeber/center";
		}else{
			mode.addAttribute("message", "用户名或密码错误！");
			return "error";
		}
		
	}
}
