package com.springmvc.config;


import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.springmvc.web.WebConfig;

/**
 * 在Servlet 3.0环境中,容器会在类路径中查找实现javax.servlet.ServletContainerInitializer接口的类,
 * 如果能发现的话,就会用来配置Servlet容器 ,
 * Spring提供了这个接口的实现SpringServletContainerInitializer,
 * 这个类反过来又会查找实现WebApplicationInitializer的类,并将配置的任务交给他们来完成,
 * Spring3.2 引入了一个遍历的WebApplicationInitializer基础实现也就是
 * AbstractAnnotationConfigDispatcherServletInitializer
 * 因为本类扩展了AbstractAnnotationConfigDispatcherServletInitializer,
 * 当部署到Servlet3.0容器中的时候,容器就会自动发现本类,并用本类来配置Servlet上下文
 *
 */
public class ChatterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * 该方法返回的带有@Configuration注解的的类
	 * 将会用来配置 ContextLoaderListener创建的bean
	 * 通常是驱动应用后端的中间层和数据层组件
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { };
	}

	/**
	 * 指定配置类
	 * 该方法中要求DispatcherServlet加载应用上下文时,
	 * 使用定义在WebConfig配置类中的bean
	 * 包括 控制器,视图解析器,处理器映射等bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * 将DispatcherServlet映射到 "/"
	 * 这表示该方法会是应用默认的Servlet,
	 * 他会处理进入应用的所有请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	/**
	 * 由于浏览器表单只支持 GET 和 POST 请求，
	 * 为了实现 DELETE 和 PUT 请求，
	 * Spring 为我们提供了一个过滤器org.springframework.web.filter.HiddenHttpMethodFilter，
	 * 可以为我们将 GET 和 POST 请求通过过滤器转化成 DELETE 和 PUT 请求
	 */
	  @Bean
	  protected Filter[] getServletFilters() {
	      return new Filter[] { new HiddenHttpMethodFilter() };
	  }
	  
	  @Override
	  protected void customizeRegistration(Dynamic registration) {
	    registration.setMultipartConfig(
	        new MultipartConfigElement("D:/java/workspace_3/spring-mvc-1/imgs/", 2097152, 4194304, 0));
	  }
}