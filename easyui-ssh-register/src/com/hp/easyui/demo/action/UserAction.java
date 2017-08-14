package com.hp.easyui.demo.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.interceptor.RequestAware;

import com.alibaba.fastjson.JSONArray;
import com.hp.easyui.demo.entity.User;
import com.hp.easyui.demo.service.UserService;

public class UserAction implements RequestAware{

	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	private ServletRequest request;
	
	//��дrequestaware �õ�ServletRequest
	@Override
	public void setRequest(Map<String, Object> map) {
		request = (ServletRequest) map.get(StrutsStatics.HTTP_REQUEST);
	}
	
	public void register() throws IOException{
		String name=request.getParameter("name") ;
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		if(name==null||email==null||subject==null||message==null){
			String response="{'success':true,'msg':'fuck you'}";
			HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
			httpServletResponse.setContentType("text/html;charset=UTF-8");
			httpServletResponse.getWriter().print(response);
			httpServletResponse.getWriter().flush();
			httpServletResponse.getWriter().close();
			return;
		}
		System.out.println(request.getRemoteAddr()+"....."+request.getRemoteHost());
		User user=new User(name,email,subject,message);
		System.out.println(user);
		userService.save(user);
		
		String response="{'success':true,'msg':'ע��ɹ�'}";
		//��servlet���л������� �ó�����Ӧ����  ȥ��Ӧ�����Ĵ���
		HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
		//���߶Է���Ӧ�����ݸ�ʽ
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		//����Ӧ���� ���ȥ
		httpServletResponse.getWriter().print(response);
		//��һ��Ӧ������ʣ����Ӧ �ô���ȥ
		httpServletResponse.getWriter().flush();
		//��Ӧ���ر�
		httpServletResponse.getWriter().close();
	}
	public void list() throws IOException{
		
		System.out.println(request.getParameter("page")+"..."+request.getParameter("rows"));
		
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		
		//������е�����
		List<User> userList=userService.getAll();
		List<User> userPageList=userService.getPageList(page, rows);
		//���������
		String total=String.valueOf(userList.size());
		//ת����json����
		String userJsonList = JSONArray.toJSONString(userPageList);
		//���ܼ�¼���Լ����м�¼תΪ"total":13,"rows":[{""}] ��ʽ
		String response = "{\"total\":"+ total+",\"rows\":"+userJsonList+"}";
//		String response="{\"total\":"+total+",\"rows\":"+userJsonList+"}";
		System.out.println(response);
		HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		httpServletResponse.getWriter().print(response);
		httpServletResponse.getWriter().flush();
		httpServletResponse.getWriter().close();
		
	}
	
	
}
