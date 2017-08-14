package cn.zk.springmvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.zk.springmvc.web.WebMVCConfig;
/**
 * 相当于web.xml
 * @author mbdn
 *
 */
public class SpringMVCDept2Config extends AbstractAnnotationConfigDispatcherServletInitializer{
	/**
	 * 配置后台相关的配置类
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}
	
	/**
	 * 将视图解析器的配置类告诉servlet上下文
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMVCConfig.class};
	}
	/**
	 * 过滤所有的请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	/**
	 * 过滤post请求 如果该表单有_method属性值，将转为对应的请求
	 * 	_method属性值为put 	将转为put	        请求
	 * _method属性值为delete 	将转为delete  请求
	 */
	@Override
	protected Filter[] getServletFilters(){
		 return new Filter[] { new HiddenHttpMethodFilter()};
	}

}
