package com.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.entity.User;

@Controller
@SessionAttributes("user")
public class ModelAttributeWithSessionAttributeController {

	@RequestMapping("testSessionAttributes")
	public String testSessionAttributes(Model model){
		User user=new User("root", "120", "3333");
		model.addAttribute("user", user);
		return "success";
	}
	
	/**
	 * 先调用testSessionAttributes 将user存放于session域中
	 * 可能因为@SessionAttributes标注的使用已经存在于model中
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user")
	public String save(@ModelAttribute("user") User user) {
		System.out.println("save user:"+user);
		return "success";
	}
}
