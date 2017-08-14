package cn.zk.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="cn.zk.springmvc")
public class WebViewConfig {

	@Bean
	public ViewResolver viewResolver(){
		//通过构造器构建视图解析器
		InternalResourceViewResolver viewResolver
			=new InternalResourceViewResolver(
						"/WEB-INF/views/", ".jsp");
		return viewResolver;
	}
}
