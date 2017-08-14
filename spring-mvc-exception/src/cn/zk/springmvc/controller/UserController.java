package cn.zk.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.zk.springmvc.entity.User;
import cn.zk.springmvc.exception.UserNotFoundException;
import cn.zk.springmvc.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String user(@PathVariable Integer id,Model model){
		User user=userRepository.get(id);
		if(user==null){
			throw new UserNotFoundException();
		}
		model.addAttribute(user);
		return "user";
	}
}
