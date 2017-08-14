package com.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.entity.User;

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
		System.out.println("RequestMapping Ant风格的URI已经到来......");
		return "success";
	}
	
	/**
	 * 处理形如testRequestParam?age=3的请求
	 * 本质上为通过HTTP发起的RPC
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("testRequestParam")
	public String testRequestParam(@RequestParam(value="name",defaultValue="Tom")String name,@RequestParam(value="age",required=false)Integer age){
		System.out.println("testRequestParam:name->"+name+",age->"+age);
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
	
	/**
	 * 请求地址带有占位符 占位符使用{}括起来
	 * 添加@PathVariable注解 表明在请求路径中，
	 * 不管占位符的值是什么都会传递到处理器方法的id参数中去
	 * @param id
	 * @return
	 */
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
	
	@RequestMapping("testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String value){
		System.out.println("testRequestHeader:"+value);
		return "success";
	}
	
	
	
	@RequestMapping("testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID")String cookie){
		System.out.println("testCookieValue:"+cookie);
		return "success";
	}
	
	/**
	 * 处理表单
	 * User 对象将使用请求中的同名参数进行填充
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user){
		System.out.println("testRegister:"+user);
		//注册成功之后重定向操作
		return "success";
	}
	
	@RequestMapping("restForward")
	public String testForward(){
		return "forward:/index.jsp";
	}
	
	@RequestMapping("testRedirect")
	public String testRedirect(){
		return "redirect:/index.jsp";
	}
	/**
	 * 传递模型数据到视图中
	 * model实际上就是一个map 将会传递给视图 这样数据就能渲染到客户端了
	 * 当视图是jsp 的时候 模型数据会作为请求属性放入到请求（request)之中
	 * 此model可使用map代替
	 */
	@RequestMapping("list")
	public String testSendModelToJsp(Model model){
		List<User> userList=new ArrayList(){{
			add(new User("AA","111","136890"));
			add(new User("BB","222","136890"));
			add(new User("CC","333","136890"));
			add(new User("DD","444","136890"));
		}};
		model.addAttribute("userList", userList);
		return "list";
	}
	
	
}
	
