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
	 * 告诉springmvc将请求转换为何种类型的视图
	 */
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		//配置视图解析器的前缀 /WEB-INF/views/home
		viewResolver.setPrefix("/WEB-INF/views/");
		//配置视图解析器的后缀 .jsp
		viewResolver.setSuffix(".jsp");
		//前缀+home+后缀 /WEB-INF/views/home.jsp
		return viewResolver;
	}
	/**
	 * 自定义视图解析器
	 * 需要设置优先级 值越小 优先级越高
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
