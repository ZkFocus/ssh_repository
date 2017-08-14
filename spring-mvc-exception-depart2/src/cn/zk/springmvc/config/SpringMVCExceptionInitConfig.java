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
	 * 配置数据源等后端的配置类
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}
	/**
	 * 配置视图解析器等前端的配置类
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebViewConfig.class};
	}
	/**
	 * 处理所有的请求
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
