package cn.zk.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/home")
public class HomeController {
	
	
	@RequestMapping(value="method",method=RequestMethod.GET)
	public String home(){
		System.out.println("欢迎来到springMVC世界");
		return "home";
	}
	
}
