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
   * orderԽС ���ȼ�Խ��
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
	 * ���þ�̬��Դ�Ĵ���
	 */
  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	  /**
		 *  ����enable������Ҫ��DispatcherServlet���Ծ�̬��Դ������
		 *  ת����Servlet������Ĭ�ϵ�servlet��,������ʹ��DispatcherServlet������
		 *  �����������
		 */
    configurer.enable();
  }
  


}
