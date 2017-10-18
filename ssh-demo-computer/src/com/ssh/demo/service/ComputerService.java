package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.entity.Computer;
import com.ssh.demo.repository.ComputerRepository;

public class ComputerService {
	
	private ComputerRepository computerRepository;
	
	public void setComputerRepository(ComputerRepository computerRepository) {
		this.computerRepository = computerRepository;
	}
	public List<Computer> getAllComputer(){
		return computerRepository.getAllComputer();
	}
	
	
	public void delete(Integer id){
		computerRepository.delete(id);
	}
	
	
	public void saveOrUpdate(Computer computer){
		computerRepository.saveOrUpdate(computer);
	}
	
	
	public Computer get(Integer id){
		return computerRepository.get(id);
	}
}
