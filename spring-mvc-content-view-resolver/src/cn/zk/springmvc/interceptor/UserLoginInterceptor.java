package cn.zk.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.zk.springmvc.repository.UserRepository;

@Component
public class UserLoginInterceptor implements HandlerInterceptor{

	@Autowired
	private UserRepository userRepository;
	/*
	 * preHandle����ִ��action����Ĵ����߼�֮ǰִ�У������ص���boolean��
	 * ����������Ƿ���true�ڽ���ִ��postHandle��afterCompletion��
	 * ������Ƿ���false���ж�ִ�С�
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle......");
		
		return true;
	}
	/*
	 * postHandle����ִ��action������߼��󷵻���ͼ֮ǰִ�С�
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle......");
	}
	/*
	 * afterCompletion����action������ͼ��ִ�С�
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion......");
	}

	
}
