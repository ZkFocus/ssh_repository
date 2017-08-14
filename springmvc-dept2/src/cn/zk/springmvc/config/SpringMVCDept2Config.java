package cn.zk.springmvc.config;

import javax.servlet.Filter;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.zk.springmvc.web.WebMVCConfig;
/**
 * �൱��web.xml
 * @author mbdn
 *
 */
public class SpringMVCDept2Config extends AbstractAnnotationConfigDispatcherServletInitializer{
	/**
	 * ���ú�̨��ص�������
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {};
	}
	
	/**
	 * ����ͼ�����������������servlet������
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebMVCConfig.class};
	}
	/**
	 * �������е�����
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	/**
	 * ����post���� ����ñ���_method����ֵ����תΪ��Ӧ������
	 * 	_method����ֵΪput 	��תΪput	        ����
	 * _method����ֵΪdelete 	��תΪdelete  ����
	 */
	@Override
	protected Filter[] getServletFilters(){
		 return new Filter[] { new HiddenHttpMethodFilter()};
	}

}
