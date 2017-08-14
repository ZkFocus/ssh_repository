package cn.zk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController {

	@RequestMapping("testException")
	public String testException(@RequestParam int i){
		System.out.println(5 / i);
		return "success";
	}
	/**
	 * @ExceptionHandler 用于处理同一个控制器类中所有处理器方法的异常
	 */
	/*@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView handleException(Exception ex){
		//构造视图名字
		ModelAndView mv=new ModelAndView("error");
		//在视图中赋值信息
		mv.addObject("ex", ex);
		return mv;
	}*/
}
