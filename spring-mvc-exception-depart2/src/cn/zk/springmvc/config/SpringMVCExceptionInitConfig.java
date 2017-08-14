package cn.zk.springmvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 
 * @author mbdn
 *
 */
public class SpringMVCExceptionInitConfig 
	extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * ��������Դ�Ⱥ�˵�������
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	/**
	 * ������ͼ��������ǰ�˵�������
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
