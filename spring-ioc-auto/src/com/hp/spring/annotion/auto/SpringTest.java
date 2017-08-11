package com.hp.spring.annotion.auto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJUnit4ClassRunner 提供spring测试用的容器
 * @ContextConfiguration(classes=AutoConfig.class) 基于哪个配置类 相当于配置文件
 * ApplicationContext ac=new ClassPathXMLApplicationContext（"beans.xml"）;
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AutoConfig.class)
public class SpringTest {

	//@Autowired 自动注入 根据bean的类型
	//<bean id="guitar" class="com.hp.spring.annotion.auto.Guitar">
	//<property><ref=""></property>
	//</bean>
	//IHello hello =(IHello)ac.getBean("");
	@Autowired
	private Performance performance;
	
	@Test
	public void test(){
		performance.perform();
	}
}
