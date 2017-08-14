package cn.zk.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zk.springmvc.entities.User;

@Controller
public class UserController {



	@RequestMapping(value = "/testRegister", 
					method = RequestMethod.POST)
	public String processRegistration(User user,
					RedirectAttributes reAttributes) {
		reAttributes.addFlashAttribute("user", user);
		return "redirect:/welcome";
	}
	
}
