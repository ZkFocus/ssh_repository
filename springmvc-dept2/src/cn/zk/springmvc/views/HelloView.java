package cn.zk.springmvc.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

@Component
public class HelloView implements View{

	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, 
				HttpServletRequest request, 
				HttpServletResponse response)
			throws Exception {
		response.getWriter().println("Hello SpringMVC View.This is myself view");
	}

}
