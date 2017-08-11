package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.entity.User;
import com.ssh.demo.repository.UserRepository;

public class UserService {

	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public List<User> getAllUser(){
		return userRepository.getAllUser();
	}
}
