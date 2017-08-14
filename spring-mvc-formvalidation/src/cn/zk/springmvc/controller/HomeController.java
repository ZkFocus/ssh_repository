package cn.zk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(){
		return "index";
	}
	@RequestMapping(value="home/{name}",method=RequestMethod.GET)
	public String home(@PathVariable String name,Model model){
		model.addAttribute("name", name);
		return "home";
	}
}
