package cn.zk.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exception")
public class ExceptionController {
	
	/**
	 * @ExceptionHandler �����쳣
	 * 		������ֻ�ܴ�������µ��쳣������
	 * 	���ܴ�������������controller�����쳣
	 * 		value ����ָ���쳣������ 
	 * @param ex
	 * @return
	 */
	/*@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView modelAndView(Exception ex){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		if(ex.getMessage().contains("/ by zero")){
			mv.addObject("exception", "��������Ϊ0");
		}
		return mv;
	}*/
	
	
	@RequestMapping("ex/{i}")
	public String testException(@PathVariable int i,Model model){
		int result= 5 / i;
		model.addAttribute("result", result);
		return "excep";
	}
}
