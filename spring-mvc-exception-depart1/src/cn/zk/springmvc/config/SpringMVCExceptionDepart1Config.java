package cn.zk.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringMVCExceptionDepart1Config extends 
	AbstractAnnotationConfigDispatcherServletInitializer{
	
	/**
	 * �������ݲ�Ⱥ����ص�������
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	/**
	 * ������ͼ��ǰ����ص�������
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebViewConfig.class};
	}

	/**
	 * �������е�����
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	
}
