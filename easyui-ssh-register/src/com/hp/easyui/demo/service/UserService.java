package com.hp.easyui.demo.service;

import java.util.List;

import com.hp.easyui.demo.entity.User;
import com.hp.easyui.demo.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void save(User user){
		userRepository.save(user);
	}
	public List<User> getAll(){
		return userRepository.getAll();
	}
	public List<User> getPageList(String page,String rows){
		return userRepository.getPageList(page, rows);
				
	}
}
