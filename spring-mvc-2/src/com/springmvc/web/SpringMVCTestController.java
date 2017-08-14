package com.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringMVCTestController {

	/**
	 * @RequestMapping(value="",method ={"",""},headers={},params={"",""})
	 */
	
	/**
	 * 测试value
	 * value :String[] 设置访问地址 
	 * eg：value={"/testRequestMappingValue","/testValue"}
	 * 
	 * @return
	 */
	@RequestMapping(value="testRequestMappingValue")
	public String testRequestMappingValue(){
		return "success";
	}
	
	/**
	 * method: RequestMethod[]设置访问方式，字符数组，包括GET, HEAD, POST, PUT...
	 * @return
	 */
	@RequestMapping(value="testRequestMappingMethod",method=RequestMethod.GET)
	public String testRequestMappingMethod(){
		return "success";
	}
	
	/**
	 * params支持简单的表达式操作 
	 * 	params="!name" 请求参数中不能包含name属性 
	 * 	params={"!name","age=10"} 请求参数中不能包含name属性且age属性必须为10
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingParams",params={"!name","password=123456"})
	public String testRequestMappingParams(){
		return "success";
	}
	
	/**
	 *  headers 属性，可以限制客户端发来的请求
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingHeaders",headers="Host=localhost:8080")
	public String testRequestMappingHeaders(){
		System.out.println("from host=localhost:8080");
		return "success";
	}
	
	/**
	 * 			?	匹配任何单字符
	 *			*	匹配0或者任意数量的字符
	 *			**	匹配0或者更多的目录
	 */
	
	/**
	 * 可匹配“/testRequestMappingAnt/abc”，但不匹配“/testRequestMappingAntabc”;
	 * @return
	 */
	@RequestMapping(value="/testRequestMappingAnt/*")
	public String testRequestMappingAntOne(){
		return "success";
	}
	
	
	
	
	
	/**
	 * 处理形如的请求 user/1、user/2、user/3
	 * @param id
	 * @return
	 */
	/*@RequestMapping(value="/user/{id}")
	public String testRequestMappingPathVariable(@PathVariable("id")int id){
		return "success";
	}*/
	
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public String show(@PathVariable("id") Integer id) {
		System.out.println("查看id为：" + id + "的user");
		return "success";
	}
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String create() {
		System.out.println("添加user");
		return "success";
	}
	//https://stackoverflow.com/questions/24673041/405-jsp-error-with-put-method
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public String update(@PathVariable("id") Integer id) {
		System.out.println("更新id为：" + id + "的user");
		return "success";
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public String destroy(@PathVariable("id") Integer id) {
		System.out.println("删除id为：" + id + "的user");
		return "success";
	}
	
	
}
	
