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
	 * @ExceptionHandler �����쳣
	 * 		������ֻ�ܴ�����������쳣��Ϣ������
	 * 			value ָ���쳣����
	 * @return
	 */
	/*@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView ModelAndView(Exception exception){
		ModelAndView mv=new ModelAndView();
		// ������ͼ����
		mv.setViewName("error");
		// ����ͼ�������ģ������
		mv.addObject("exception", "��������Ϊ0"+exception.getLocalizedMessage());
		return mv;
	}*/

	@RequestMapping("testEx/{i}")
	public String testException(@PathVariable int i,Model model){
		int result=5 / i;
		model.addAttribute("result",result);
		return "ex";
	}
}
