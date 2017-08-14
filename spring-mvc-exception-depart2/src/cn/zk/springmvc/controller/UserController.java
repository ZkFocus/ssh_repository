package cn.zk.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zk.springmvc.entity.User;
import cn.zk.springmvc.exception.UserNotFoundException;
import cn.zk.springmvc.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository; 

	@RequestMapping("getUser/{id}")
	public String getUser(@PathVariable int id,Model model){
		User user=userRepository.getUserById(id);
		if(user == null){
			throw new UserNotFoundException();
		}
		model.addAttribute(user);
		return "success";
	}
}
