package com.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.demo.dao.CustomerMapper;
import com.mybatis.demo.entity.Customer;

public class MyBatisDemo {
	
	private SqlSessionFactory sqlSessionFactory ;
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testGetCustomerAndOrdersByName() throws IOException{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomerAndOrdersByName("Tom");
		System.out.println(customer);
		//System.out.println(customer.getOrders());
		sqlSession.close();
	}
	@Test
	public void testGetCustomerByIdStep() throws IOException{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
		Customer customer = mapper.getCustomerByIdStep(1);
		System.out.println(customer.getEmail());
		System.out.println(customer.getOrders());
		sqlSession.close();
		
	}

}
