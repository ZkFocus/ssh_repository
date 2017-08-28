package com.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.demo.dao.UserResultMap;
import com.mybatis.demo.entity.User;

public class MyBatisDemo {
	
	private SqlSessionFactory sqlSessionFactory ;
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}
	
	
	@Test
	public void testResultMap() throws IOException{
		SqlSession openSession = getSqlSessionFactory().openSession();
		UserResultMap userResultMap=openSession.getMapper(UserResultMap.class);
		User user = userResultMap.getUserById(1);
		System.out.println(user);
		openSession.close();
	}
	
	@Test
	public void testResultMap2() throws IOException{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		UserResultMap userResultMap=sqlSession.getMapper(UserResultMap.class);
		User user = userResultMap.getUserAndAddr(3);
		System.out.println(user);
		sqlSession.close();
	}
	/**
	 * 通过Association分步查询
	 * @throws IOException 
	 */
	@Test
	public void testGetUserByIdAssociation() throws IOException{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		UserResultMap userResultMap=sqlSession.getMapper(UserResultMap.class);
		User user = userResultMap.getUserByIdAssociation(1);
		System.out.println(user);
		sqlSession.close();
	}
	/**
	 * 
	 * 全局配置开启
	<settings>
		<setting name="lazyLoadingEnabled" value="true"/>
		<setting name="aggressiveLazyLoading" value="false"/>
	</settings>
	 * @throws IOException 
	 */
	@Test
	public void testGetUserLazy() throws IOException{
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		UserResultMap userResultMap=sqlSession.getMapper(UserResultMap.class);
		User user = userResultMap.getUserByIdAssociation(1);
		System.out.println(user.getName());
		System.out.println(user.getAddress());
		sqlSession.close();
	}
}
