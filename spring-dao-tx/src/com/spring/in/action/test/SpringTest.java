package com.spring.in.action.test;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	
	private ApplicationContext  act=null;
	private DataSource daSource=null;
	
	{
		act=new ClassPathXmlApplicationContext("application.xml");
		daSource=(DataSource) act.getBean("dataSource");
	}
	
	
	@Test
	public void testSource(){
		System.out.println(daSource);
	}

}
