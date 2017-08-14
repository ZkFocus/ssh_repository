package cn.zk.springmvc.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cn.zk.springmvc.entity.User;

/**
 * @Controller 其实就是@Component 作用一模一样
 * 但是@Controller 表意效果更明显
 * @author mbdn
 *
 */
@Controller
public class RequestMappingController {

	/**
	 * @RequestMapping(value="",method ={"",""},headers={},params={"",""})
	 */
	
	
	/**
	 * @RequestMapping 可以用于方法上 也可以用于类名上
	 * 如果用在类名上  需要访问某个具体的方法的话 
	 * 		访问形式如：类名上的RequestMapping + 方法上的RequestMapping
	 * @return
	 */
	
	@RequestMapping(value={"testRequestMappingValues","testRequestMappingValuesAgain"})
	public String testRequestMappingValues(){
		
		return "success";
	}
	
	/**
	 * Ant风格
	 * 			?	匹配任何单字符
	 *			*	匹配0或者任意数量的字符
	 *			**	匹配0或者更多的目录
	 */
	@RequestMapping("testRequestMappingValues*")
	public String testRequestMappingValuesAnt(){
		
		return "success";
	}
	/**
	 * method属性用于映射请求的方式 请求方式包括GET PUT DELETE POST ...
	 * @return
	 */
	@RequestMapping(value="testRequestMappingMethod",method={RequestMethod.POST,RequestMethod.GET})
	public String testRequestMappingMethod(){
		
		return "success";
	}
	/**
	 * 映射符合请求头消息的请求 才能进来该方法
	 * @return
	 */
	@RequestMapping(value="testRequestMappingHeaders",headers="Host=localhost:8080")
	public String testRequestMappingHeaders(){
		System.out.println("本机的请求");
		return "success";
	}
	
	/**
	 * 通过请求参数来 过滤请求
	 * @return
	 */
	@RequestMapping(value="testRequestMappingParams",params="name!=admin")
	public String testRequestMappingParams(){
		
		return "success";
	}
	/**
	 * @RequestParam 
	 * 			name属性4.2版本以后才有，绑定请求参数 同value
	 * 			requeired 请求参数是否必须
	 * 			defaultvalues 用于设置默认值 
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("testRequestParams")
	public String testRequestParams(
			@RequestParam(name="name",required=true)String name,
			@RequestParam(name="password",required=false,
				defaultValue="123456")String password
			)
	{
		System.out.println(name+"===="+password);
		return "success";
	}
	/**
	 * @RequestMapping 允许我们使用占位符 “{}”
	 * @param userid
	 * @return
	 */
	@RequestMapping("testPathVariable/{userId}")
	public String testPathVariable(
				@PathVariable("userId")Integer userid
								  ){
		System.out.println("获取id为"+userid+"的user");
		return "success";
	}
	/**
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRegister",method=RequestMethod.POST)
	public String testRegister(User user,RedirectAttributes model){
		System.out.println("save user:"+user);
//		return "success";
		model.addFlashAttribute("user",user);
		return "redirect:/method";
//		return "forward:/method";
	}
	/**
	 * model 实际上就是一个map
	 * 在jsp页面上可以直接通过request域获取到model中的值
	 * @param model
	 * @return
	 */
	@RequestMapping("testList")
	public String testList(Model model){
		List<User> userList=new ArrayList<User>(){{
			add(new User("AA","123","111"));
			add(new User("BB","456","222"));
			add(new User("CC","789","333"));
			add(new User("DD","0AB","444"));
		}};
		model.addAttribute("userList", userList);
		
		return "list";
	}
	/**
	 * 重定向
	 * @return
	 */
	@RequestMapping("testRedirect")
	public String testRedirect(){
		
		return "redirect:/method";
	}
	/**
	 * 转发
	 * @return
	 */
	@RequestMapping("testForward")
	public String testForward(){
		
		return "forward:/method";
	}
	/**
	 * REST风格的获取操作
	 * @param id
	 * @return
	 */
	@RequestMapping("testRestGet/{id}")
	public String testRestGet(@PathVariable(name="id")Integer id){
		System.out.println("获取ID为："+id+"的User对象");
		return "success";
	}
	/**
	 * REST风格的保存操作
	 * @param user
	 * @return
	 */
	@RequestMapping(value="testRestPost",method=RequestMethod.POST)
	public String testRestPost(User user){
		System.out.println("保存对象"+user);
		return "success";
	}
	/**
	 * REST风格的修改
	 * @return
	 */
	@RequestMapping(
				value="testRestPut/{id}",
				method=RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id){
		System.out.println("修改对象");
		return "success";
	}
	@RequestMapping(
				value="testRestDelete/{id}",
					method=RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id){
		System.out.println("删除对象");
		return "success";
	}
	
	@RequestMapping("testView")
	public String testView(){
		
		return "helloView";
	}
	
}
