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
	 * 配置一个视图解析器
	 * 告诉springmvc将视图响应处理为何种类型的视图
	 * @return
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver internalResourceViewResolver
			=new InternalResourceViewResolver();
		//设置视图前缀
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		//设置视图后缀
		internalResourceViewResolver.setSuffix(".jsp");
		//返回如："home"  处理后为：/WEB-INF/views/home.jsp
		return internalResourceViewResolver;
	}
	/**
	 * order 值越小 优先级越高
	 * @return
	 */
	/*@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver resolver=new BeanNameViewResolver();
		resolver.setOrder(2);
		return resolver;
	}*/
	
}
