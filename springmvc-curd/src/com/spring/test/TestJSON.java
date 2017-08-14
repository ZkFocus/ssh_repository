package com.spring.test;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.dao.EmployeeDao;
import com.spring.entities.Employee;

@Controller
public class TestJSON {

	@Autowired
	private EmployeeDao employeeDao;
	
	@ResponseBody
	@RequestMapping("/testJson")
	public Collection<Employee> testJson(){
		
		return employeeDao.getAll();
	}
}
