package cn.zk.springmvc.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller 相当于是@Component  告诉spring容器它是一个bean
 * 但是@Controller 表意效果更明显
 * @author mbdn
 *
 */
@Controller
@RequestMapping("home")
public class HomeController {
	
	/**
	 * @RequestMapping
	 * 	既可以用于类名上也可以用于方法名上 
	 * 	用于映射请求地址 请求方式 请求参数 请求头...
	 * @return
	 */
//	@RequestMapping(value="home",method=RequestMethod.GET)
	@RequestMapping(method=RequestMethod.GET)
	public String home(){
		/*if(model.containsAttribute("user")){
			System.out.println("model包含："+model);
		}*/
		return "home";
	}
}
