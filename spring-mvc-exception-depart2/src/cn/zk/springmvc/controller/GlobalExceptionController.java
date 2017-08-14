package cn.zk.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice
 * 处理整个项目的异常
 * @author mbdn
 *
 */
@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView ModelAndView(Exception exception){
		ModelAndView mv=new ModelAndView();
		// 设置视图名字
		mv.setViewName("error");
		// 在视图中添加域模型数据
		mv.addObject("exception", "除数不能为0"+exception.getLocalizedMessage());
		return mv;
	}
}
