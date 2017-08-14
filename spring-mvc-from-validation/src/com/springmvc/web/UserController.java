package com.springmvc.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {


	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid User user, Errors errors) {
		if (errors.hasErrors()) {
			return "registerForm";
		}

		return "redirect:/user/" + user.getUsername();
	}
	@RequestMapping(value = "/{username}", method = GET)
	public String showSpitterProfile(@PathVariable String username, Model model) {
		model.addAttribute("name",username);
		return "profile";
	}
}
