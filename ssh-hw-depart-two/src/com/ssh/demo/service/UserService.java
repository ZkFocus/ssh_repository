package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.entity.User;
import com.ssh.demo.repository.UserRepository;

/**
 * 业务逻辑处理层
 * @author asus
 *
 */

public class UserService {

	private UserRepository userRepository;
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUser(){
		//to do sth
		List<User> users=userRepository.getAllUser();
		return users;
	}
	
	public void saveOrUpdate(User user){
		userRepository.saveOrUpdate(user);
	}
	
	public void delete(Integer id){
		userRepository.delete(id);
	}
	public User get(Integer id) {
		return userRepository.get(id);
	}

}
