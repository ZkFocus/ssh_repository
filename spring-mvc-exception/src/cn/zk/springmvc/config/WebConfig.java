package cn.zk.springmvc.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("cn.zk.springmvc")
public class WebConfig extends WebMvcConfigurerAdapter {

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
  /**
   * order越小 优先级越高
   * @return
   */
  @Bean
  public BeanNameViewResolver beanNameViewResolver(){
	  BeanNameViewResolver beanNameViewResolver=new BeanNameViewResolver();
	  beanNameViewResolver.setOrder(1000);
	  return beanNameViewResolver;
  }
  
  
  @Bean
  public MultipartResolver multipartResolver() throws IOException {
    return new StandardServletMultipartResolver();
  }
  
  
  
  /**
	 * 配置静态资源的处理
	 */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	  /**
		 *  调用enable方法来要求DispatcherServlet将对静态资源的请求
		 *  转发到Servlet容器中默认的servlet上,而不是使用DispatcherServlet本身来
		 *  处理此类请求
		 */
    configurer.enable();
  }
  


}
