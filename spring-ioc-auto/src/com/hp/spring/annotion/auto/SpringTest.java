package com.hp.spring.annotion.auto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJUnit4ClassRunner �ṩspring�����õ�����
 * @ContextConfiguration(classes=AutoConfig.class) �����ĸ������� �൱�������ļ�
 * ApplicationContext ac=new ClassPathXMLApplicationContext��"beans.xml"��;
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AutoConfig.class)
public class SpringTest {

	//@Autowired �Զ�ע�� ����bean������
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
