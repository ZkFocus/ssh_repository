package cn.zk.springmvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * ���ڴ��� ���� �������д������������쳣 
 * @ControllerAdvice������֪ͨ
 * @author mbdn
 *
 */
@ControllerAdvice
public class WideExceptionController {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView handleException(Exception ex){
		//������ͼ����
		ModelAndView mv=new ModelAndView("error");
		//����ͼ�и�ֵ��Ϣ
		mv.addObject("ex", ex);
		return mv;
	}
}
