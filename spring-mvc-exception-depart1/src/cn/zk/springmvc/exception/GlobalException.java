package cn.zk.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author mbdn
 * 在带有@ControllerAdvice注解的类中，这个类会包含一个或多个如下类型的方法
	@ExceptionHandler注解标注的方法；
	@InitBinder注解标注的方法；
	@ModelAttribute注解标注的方法。 
这些方法会运用到整个应用程序所有控制器中带有@RequestMapping注解的方法上。
 *
 */

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView modelAndView(Exception ex){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		if(ex.getMessage().contains("/ by zero")){
			mv.addObject("exception", "除数不能为0");
		}
		return mv;
	}
	
}
