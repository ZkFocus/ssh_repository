package com.spring.handlers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.dao.DepartmentDao;
import com.spring.dao.EmployeeDao;
import com.spring.entities.Department;
import com.spring.entities.Employee;

@Controller
public class EmployeeHandler {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao  departmentDao;
	  
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false)Integer id,Map<String,Object> map){
		if(id!=null){
			map.put("employee", employeeDao.get(id));
		}
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.PUT)
	public String update(Employee employee){
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.GET)
	public String input(@PathVariable("id")Integer id ,Map<String,Object> map){
		map.put("employee", employeeDao.get(id));
		map.put("departments", departmentDao.getDepartments());
		return "input";
	}
	
	@RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id){
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	
	@RequestMapping(value="/emp",method=RequestMethod.POST)
	public String save(Employee employee){
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="/emp",method=RequestMethod.GET)
	public String input(Map<String,Object> map){
		map.put("departments", departmentDao.getDepartments());
		//表单标签如果要正常显示，
		//请求域中得有一个bean bean的属性需要和表单字段一一对应 这样表单才能正常显示
		//form表单使用 modelAttribute="employee"
		//此时不需要表单回显 所以new一个就OK
		map.put("employee", new Employee());
		return "input";
	}
	
	
	@RequestMapping("/emps")
	public String list(Map<String,Object> map){
		map.put("employees", employeeDao.getAll());
		return "list";
	}
	
}
