package cn.zk.springmvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zk.springmvc.entity.User;

/**
 * @Controller 其实就是@Component 作用一模一样 但是@Controller 表意效果更明显
 * @author mbdn
 *
 */
@Controller
@RequestMapping("form")
public class FormValidationController {

	@RequestMapping(value="/register",method=RequestMethod.GET)
//	@GetMapping("register")
	public String showRegistrationForm(Model model){
		model.addAttribute(new User());
		return "registerForm";
		
	}

	@RequestMapping(value="/register",method = RequestMethod.POST)
//	@PostMapping
	public String testRegister(@Valid User user, Errors error) {
		if(error.hasErrors()){
			return "registerForm";
		}
		return "redirect:/home/" + user.getName();
	}
}
