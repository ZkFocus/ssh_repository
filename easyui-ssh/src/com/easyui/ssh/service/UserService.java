package com.easyui.ssh.service;

import com.easyui.ssh.entity.User;
import com.easyui.ssh.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public void saveOrUpdate(User user){
		userRepository.saveOrUpdate(user);
	}
}
