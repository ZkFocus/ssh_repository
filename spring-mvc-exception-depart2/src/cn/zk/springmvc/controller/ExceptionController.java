package cn.zk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ex")
public class ExceptionController {
	/**
	 * @ExceptionHandler 处理异常
	 * 		！！！只能处理所在类的异常信息！！！
	 * 			value 指定异常类型
	 * @return
	 */
	/*@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView ModelAndView(Exception exception){
		ModelAndView mv=new ModelAndView();
		// 设置视图名字
		mv.setViewName("error");
		// 在视图中添加域模型数据
		mv.addObject("exception", "除数不能为0"+exception.getLocalizedMessage());
		return mv;
	}*/

	@RequestMapping("testEx/{i}")
	public String testException(@PathVariable int i,Model model){
		int result=5 / i;
		model.addAttribute("result",result);
		return "ex";
	}
}
