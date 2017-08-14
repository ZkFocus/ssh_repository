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
	
	//重写requestaware 拿到ServletRequest
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
		
		String response="{'success':true,'msg':'注册成功'}";
		//从servlet运行环境里面 拿出来响应对象  去回应请求后的处理
		HttpServletResponse httpServletResponse = ServletActionContext.getResponse();
		//告诉对方回应的内容格式
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		//将响应内容 输出去
		httpServletResponse.getWriter().print(response);
		//万一响应流里有剩余响应 得吹出去
		httpServletResponse.getWriter().flush();
		//响应流关闭
		httpServletResponse.getWriter().close();
	}
	public void list() throws IOException{
		
		System.out.println(request.getParameter("page")+"..."+request.getParameter("rows"));
		
		String page=request.getParameter("page");
		String rows=request.getParameter("rows");
		
		//获得所有的数据
		List<User> userList=userService.getAll();
		List<User> userPageList=userService.getPageList(page, rows);
		//获得总条数
		String total=String.valueOf(userList.size());
		//转换成json数组
		String userJsonList = JSONArray.toJSONString(userPageList);
		//将总记录数以及所有记录转为"total":13,"rows":[{""}] 格式
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
