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
	 * preHandle：在执行action里面的处理逻辑之前执行，它返回的是boolean，
	 * 这里如果我们返回true在接着执行postHandle和afterCompletion，
	 * 如果我们返回false则中断执行。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle......");
		
		return true;
	}
	/*
	 * postHandle：在执行action里面的逻辑后返回视图之前执行。
	 */

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle......");
	}
	/*
	 * afterCompletion：在action返回视图后执行。
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion......");
	}

	
}
