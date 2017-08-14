package cn.zk.springmvc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="cn.zk.springmvc")
public class WebMVCConfig extends WebMvcConfigurerAdapter{

	/**
	 * ����springmvc������ת��Ϊ�������͵���ͼ
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//������ͼ��������ǰ׺ /WEB-INF/views/home
		viewResolver.setPrefix("/WEB-INF/views/");
		//������ͼ�������ĺ�׺ .jsp
		viewResolver.setSuffix(".jsp");
		//ǰ׺+home+��׺ /WEB-INF/views/home.jsp
		return viewResolver;
	}
	/**
	 * �Զ�����ͼ������
	 * ��Ҫ�������ȼ� ֵԽС ���ȼ�Խ��
	 * @return
	 */
	@Bean
	public BeanNameViewResolver beanNameViewResolver(){
		BeanNameViewResolver beanNameViewResolver
			=new BeanNameViewResolver();
		beanNameViewResolver.setOrder(Integer.MAX_VALUE-1);
		return beanNameViewResolver;
		
	}
}
