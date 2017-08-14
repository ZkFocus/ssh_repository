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
	 * @ModelAttribute��ע�ɱ�Ӧ���ڷ����򷽷������ϡ�
		��ע�ڷ����ϵ�@ModelAttribute˵���������������һ���������Ե�model�ϡ������ķ����ܽ�����@RequestMapping��ע��ͬ�Ĳ������ͣ�ֻ��������ֱ�ӱ�ӳ�䵽����������ϡ�
		��ͬһ���������У���ע��@ModelAttribute�ķ���ʵ���ϻ���@RequestMapping����֮ǰ�����á�
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
		System.out.println("�޸�user����"+user);
		return "success";
	}
}
