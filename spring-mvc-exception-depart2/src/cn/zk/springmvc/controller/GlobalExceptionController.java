package cn.zk.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice
 * ����������Ŀ���쳣
 * @author mbdn
 *
 */
@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView ModelAndView(Exception exception){
		ModelAndView mv=new ModelAndView();
		// ������ͼ����
		mv.setViewName("error");
		// ����ͼ�������ģ������
		mv.addObject("exception", "��������Ϊ0"+exception.getLocalizedMessage());
		return mv;
	}
}
