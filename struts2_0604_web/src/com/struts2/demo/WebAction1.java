package com.struts2.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class WebAction1 {

	private String username;
	private String password;

	public String execute() {

		if ("admin".equals(username) && "admin".equals(password)) {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			/**
			 *  ServletActionContext�̳���ActionContext,���ṩ��ֱ����Servlet��ض�����ʵĹ���
			 *  ActionContext��Actionִ��ʱ��������,�����Ŀ��Կ���Ϊ����,����ŵ���Action��ִ��ʱ�õ��Ķ���. 
			 *  �鿴Դ���֪actioncontext���̰߳�ȫ��
			 *  ��ThreadLocal��Ϊÿһ���̶߳�ά�����Լ����еı���������ÿ���̶߳�ӵ�����Լ�������һ��������
			 *  
			 */
			//�̰߳�ȫҪ��ÿ���̶߳��Ƕ������еģ�����HttpServletRequest�ô���ҲӦ���Ƕ�����
			HttpServletRequest request = ServletActionContext.getRequest();
			System.out.println(request.getParameter("username")+"----");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "success";
		} else {
			return "error";
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
