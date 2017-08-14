package cn.zk.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * 用于处理 所有 控制器中处理器方法的异常 
 * @ControllerAdvice控制器通知
 * @author mbdn
 *
 */
@ControllerAdvice
public class WideExceptionController {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView handleException(Exception ex){
		//构造视图名字
		ModelAndView mv=new ModelAndView("error");
		//在视图中赋值信息
		mv.addObject("ex", ex);
		return mv;
	}
}
