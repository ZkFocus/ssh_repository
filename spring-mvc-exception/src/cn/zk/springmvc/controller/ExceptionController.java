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
	 * @ExceptionHandler ���ڴ���ͬһ���������������д������������쳣
	 */
	/*@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView handleException(Exception ex){
		//������ͼ����
		ModelAndView mv=new ModelAndView("error");
		//����ͼ�и�ֵ��Ϣ
		mv.addObject("ex", ex);
		return mv;
	}*/
}
