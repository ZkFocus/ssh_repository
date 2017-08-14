package cn.zk.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zk.springmvc.entity.User;

@Controller
public class TestRequestMappingController {
	/**
	 * 访问地址为：
	 * 		类名上加上@RequestMapping("springmvc")
	 * 		http://localhost:8080/springmvc-dept2/
	 * 				springmvc/testRequestMappingValues
	 * 		类名上没加@RequestMapping
	 * 		http://localhost:8080/springmvc-dept2/
	 * 				testRequestMappingValues
	 * @return
	 */
	@RequestMapping(value="testRequestMappingValues")
	public String testRequestMappingValues(){
		
		return "success";
	}
	
	@RequestMapping(value={"testRequestMappingValues","testValues"})
	public String testRequestMappingValuesArrays(){
		
		return "success";
	}
	/**
	 * Ant风格
	 * 			?	匹配任何单字符
	 *			*	匹配0或者任意数量的字符
	 *			**	匹配0或者更多的目录
	 */
	@RequestMapping("testRequestMappingValuesAnt*")
	public String testRequestMappingValuesAnt(){
		
		return "success";
	}
	/**
	 * method 指定请求的方式 
	 * 		GET POST DELETE PUT...
	 * @return
	 */
	@RequestMapping(value="testMethod",method=RequestMethod.POST)
	public String testRequestMappingMethod(){
		return "success";
	}
	/**
	 * 指定HTTP请求头的格式
	 * @return
	 */
	@RequestMapping(value="testHeaders",headers="Accept-Language=en-US,zh-CN;q=0.8,zh;q=0.6,en;q=0.4")
	public String testRequestMappingHeader(){
		return "success";
	}
	/**
	 * params限定访问参数
	 * @return
	 */
	@RequestMapping(value="testRequestMappingParams",
			params="name!=root")
	public String testRequestMappingParams(){
		
		return "success";
	}
	/**
	 * @RequestParam 用于获取请求路径中的参数
	 * 			name:用于映射请求路径中的参数属性
	 * 			required:默认为true 
	 * 			defaultValue：用于指定默认值
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("testRequestParams")
	public String testRequestParams(
					@RequestParam(name="name")String name,
					@RequestParam(name="password",required=false,
						defaultValue="123456")String password){
		System.out.println(name+"==="+password);
		return "success";
	}
	/**
	 * REST 风格的API 
	 * 请求路径上使用{}表示占位符 处理形如：getUser/123 getUser/345 的请求
	 * @param userId
	 * @return
	 */
	@RequestMapping("getUser/{userId}")
	public String testPathVariable(@PathVariable(name="userId")Integer userId){
		System.out.println("获取id 为"+userId+"的用户");
		return "success";
	}
	
	/**
	 *  请求参数中如果带有和 处理方法中的形参一模一样的参数的话 将会对形参进行赋值
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user,RedirectAttributes model){
		System.out.println(user);
//		return "success";
		model.addFlashAttribute("user", user);
		return "redirect:/home";
//		return "forward:/home";
	}
	/**
	 * model.addAttribute("userList", userList);
	 * 在jsp页面里 可以直接通过request来获取的
	 * @param model
	 * @return
	 */
	@RequestMapping("testListUsers")
	public String testListUsers(Model model){
		List<User> userList=new ArrayList<User>(){{
			add(new User("AA","111","123"));
			add(new User("BB","222","123"));
			add(new User("CC","333","123"));
		}};
		model.addAttribute("userList", userList);
		return "list";
	}
	
	@RequestMapping("testView")
	public String testView(){
		
		return "helloView";
	}
	/**
	 * 测试REST风格的API get请求
	 */
	@RequestMapping("testRestGet/{id}")
	public String testRestGet(@PathVariable Integer id){
		System.out.println("Get user from DB where id is "+id);
		return "success";
	}
	/**
	 * 测试REST风格的API POST请求
	 */
	@RequestMapping(value="testRestPost",method=RequestMethod.POST)
	public String testRestPost(User user){
		System.out.println("保存："+user);
		return "success";
	}
	/**
	 * 测试REST风格的API PUT请求
	 */
	@RequestMapping(value="testRestPut/{id}",method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("Put id为："+id+"的对象");
		return "success";
	}
	/**
	 * 测试REST风格的API DELETE请求
	 */
	@RequestMapping(value="testRestDelete/{id}",method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("Delete id为："+id+"的对象");
		return "success";
	}
	
}
