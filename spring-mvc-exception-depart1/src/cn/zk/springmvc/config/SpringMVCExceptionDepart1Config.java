package cn.zk.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCExceptionDepart1Config extends 
	AbstractAnnotationConfigDispatcherServletInitializer{
	
	/**
	 * 加载数据层等后端相关的配置类
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	/**
	 * 加载视图等前端相关的配置类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebViewConfig.class};
	}

	/**
	 * 过滤所有的请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
}
