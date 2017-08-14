package cn.zk.springmvc.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="cn.zk.springmvc")
public class WebMVCConfig extends WebMvcConfigurerAdapter{

	/**
	 * ����һ����ͼ������
	 * ����springmvc����ͼ��Ӧ����Ϊ�������͵���ͼ
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver internalResourceViewResolver
			=new InternalResourceViewResolver();
		//������ͼǰ׺
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		//������ͼ��׺
		internalResourceViewResolver.setSuffix(".jsp");
		//�����磺"home"  �����Ϊ��/WEB-INF/views/home.jsp
		return internalResourceViewResolver;
	}
	/**
	 * order ֵԽС ���ȼ�Խ��
	 * @return
	 */
	/*@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver resolver=new BeanNameViewResolver();
		resolver.setOrder(2);
		return resolver;
	}*/
	
}
