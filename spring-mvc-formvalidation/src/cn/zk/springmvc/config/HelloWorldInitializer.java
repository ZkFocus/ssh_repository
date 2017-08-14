package cn.zk.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class HelloWorldInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{};
	}
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{HelloWorldConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}

