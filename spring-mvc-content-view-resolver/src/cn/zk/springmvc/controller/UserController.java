package cn.zk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
	
	@RequestMapping("login")
	public String user(){
		
		return "success";
	}
}
