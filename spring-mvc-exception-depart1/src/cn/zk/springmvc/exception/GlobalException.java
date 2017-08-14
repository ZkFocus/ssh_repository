package cn.zk.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author mbdn
 * �ڴ���@ControllerAdviceע������У����������һ�������������͵ķ���
	@ExceptionHandlerע���ע�ķ�����
	@InitBinderע���ע�ķ�����
	@ModelAttributeע���ע�ķ����� 
��Щ���������õ�����Ӧ�ó������п������д���@RequestMappingע��ķ����ϡ�
 *
 */

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView modelAndView(Exception ex){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("error");
		if(ex.getMessage().contains("/ by zero")){
			mv.addObject("exception", "��������Ϊ0");
		}
		return mv;
	}
	
}
