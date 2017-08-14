package com.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.User;

@Controller
public class ModelAttributeController {
	/**
	 * @ModelAttribute标注可被应用在方法或方法参数上。
		标注在方法上的@ModelAttribute说明方法是用于添加一个或多个属性到model上。这样的方法能接受与@RequestMapping标注相同的参数类型，只不过不能直接被映射到具体的请求上。
		在同一个控制器中，标注了@ModelAttribute的方法实际上会在@RequestMapping方法之前被调用。
	 * @param name
	 * @return
	 */
	@ModelAttribute
	public User getUser(@RequestParam(value="name",required=false) String name){
		if(name!=null){
			System.out.println("getUser from DB where name is "+name);
		}
		return new User(name,"120","123456");
	}
	
	@RequestMapping(value="testModelAttributtes",method=RequestMethod.GET)
	public String testModelAttributtes(){
		return "update";
	}
	
	@RequestMapping(value="testUpdate",method=RequestMethod.POST)
	public String testUpdate(User user){
		System.out.println("修改user对象"+user);
		return "success";
	}
}
