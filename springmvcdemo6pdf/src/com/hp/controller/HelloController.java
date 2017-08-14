package com.hp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 
 * struts 中的namespace作用
 *
 */
@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping("/test")
	public String hello(){
		System.err.println("====");
		return "hello1";
	}
	/**
	 * 
	 * 相当于action name
	 */
	@RequestMapping("/")
	public String index(){
		System.err.println("====");
		
		return "../../login";
	}
	/**
	 * 后端往前端jsp 传值
	 * @param model
	 * @return
	 */
	@RequestMapping("/hello1")
	public String hello1(Model model){
		model.addAttribute("message", "世界你好！");
		System.err.println("====");
		return "hello1";
	}
	/**
	 * jsp与 后台交互
	 * @param model
	 * @return
	 */
	@RequestMapping("/hello2")
	public String hello2(@RequestParam( value="test1") String name2,@RequestParam( value="test") String name1,Model model){
		System.err.println("===="+name1);
		model.addAttribute("message", "世界你好！");
		model.addAttribute("name1", name1);
		System.err.println("==test1=="+name2);
		return "hello1";
	}
	/**
	 * url 参数获取
	 * @param model
	 * @return
	 */
	@RequestMapping("/hello3/{pid}")
	public String hello3(@PathVariable(value="pid") String pid1){
		System.err.println("pid1====="+pid1);
		
		return "hello1";
	}
}
