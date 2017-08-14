package com.hp.demo.properties;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans-properties.xml");
		
		DataSource dataSource=(DataSource)ac.getBean("dataSource");
		
		System.out.println(dataSource.getConnection());
		
	}
}
