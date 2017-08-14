package com.springmvc.config;


import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.springmvc.web.WebConfig;

/**
 * ��Servlet 3.0������,����������·���в���ʵ��javax.servlet.ServletContainerInitializer�ӿڵ���,
 * ����ܷ��ֵĻ�,�ͻ���������Servlet���� ,
 * Spring�ṩ������ӿڵ�ʵ��SpringServletContainerInitializer,
 * ����෴�����ֻ����ʵ��WebApplicationInitializer����,�������õ����񽻸����������,
 * Spring3.2 ������һ��������WebApplicationInitializer����ʵ��Ҳ����
 * AbstractAnnotationConfigDispatcherServletInitializer
 * ��Ϊ������չ��AbstractAnnotationConfigDispatcherServletInitializer,
 * ������Servlet3.0�����е�ʱ��,�����ͻ��Զ����ֱ���,���ñ���������Servlet������
 *
 */
public class ChatterWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	/**
	 * �÷������صĴ���@Configurationע��ĵ���
	 * ������������ ContextLoaderListener������bean
	 * ͨ��������Ӧ�ú�˵��м������ݲ����
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { };
	}

	/**
	 * ָ��������
	 * �÷�����Ҫ��DispatcherServlet����Ӧ��������ʱ,
	 * ʹ�ö�����WebConfig�������е�bean
	 * ���� ������,��ͼ������,������ӳ���bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	/**
	 * ��DispatcherServletӳ�䵽 "/"
	 * ���ʾ�÷�������Ӧ��Ĭ�ϵ�Servlet,
	 * ���ᴦ�����Ӧ�õ���������
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	/**
	 * �����������ֻ֧�� GET �� POST ����
	 * Ϊ��ʵ�� DELETE �� PUT ����
	 * Spring Ϊ�����ṩ��һ��������org.springframework.web.filter.HiddenHttpMethodFilter��
	 * ����Ϊ���ǽ� GET �� POST ����ͨ��������ת���� DELETE �� PUT ����
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