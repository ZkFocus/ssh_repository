package cn.zk.springmvc.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(value = "welcome", method = GET)
	public String showWelcome(Model model) {
		
		return "welcome";
	}
}
