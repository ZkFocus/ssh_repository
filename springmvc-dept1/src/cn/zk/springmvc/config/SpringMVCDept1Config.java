package cn.zk.springmvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.zk.springmvc.web.WebMVCConfig;
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
public class SpringMVCDept1Config extends AbstractAnnotationConfigDispatcherServletInitializer{
	/**
	 * �÷������صĴ���@Configurationע��ĵ���
	 * ������������ ContextLoaderListener������bean
	 * ͨ��������Ӧ�ú�˵��м������ݲ����
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{};
	}
	/**
	 * ָ��������
	 * �÷�����Ҫ��DispatcherServlet����Ӧ��������ʱ,
	 * ʹ�ö�����WebConfig�������е�bean
	 * ���� ������,��ͼ������,������ӳ���bean
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{WebMVCConfig.class};
	}

	/**
	 * ��DispatcherServletӳ�䵽 "/"
	 * ���ʾ�÷�������Ӧ��Ĭ�ϵ�Servlet,
	 * ���ᴦ�����Ӧ�õ���������
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	/**
	 * �������� �����ص�_method�ύ��ʽ תΪput ������delete����ʽ
	 */
	 @Override
	protected Filter[] getServletFilters() {
	     return new Filter[] { new HiddenHttpMethodFilter()};
	}
	
}
