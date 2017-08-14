package com.hp.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor{
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.err.println("===请求完成====");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.err.println("===处理请求====");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.err.println("===请求之前====");
		User user=(User) request.getSession().getAttribute("user");
		String baseUrl=request.getContextPath();
		
		
		if(StringUtils.isEmpty(user)){
			response.sendRedirect(baseUrl+"/login.jsp");
			return false;
		}
		
		return true;
	}

}
