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

import com.mybatis.demo.dao.UserManagerAnnotation;
import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.entity.User;

public class MyBatisDemo {
	
	private SqlSessionFactory sqlSessionFactory ;
	//非线程安全，多线程禁止这样定义，仅供测试使用
	private SqlSession sqlSession;
	
	@Before
	public void Before() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession=sqlSessionFactory.openSession();
	}
	
	@After
	public void after(){
		sqlSession.close();
	}

	@Test
	public void test() throws IOException{
		User user=sqlSession.selectOne("com.mybatis.demo.UserMapper.selectUser", 1);
		System.out.println(user);
	}
	
	
	@Test
	public void testInterface(){
		UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
		User user=uMapper.getUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testAnnotation(){
		UserManagerAnnotation manager=sqlSession.getMapper(UserManagerAnnotation.class);
		User user=manager.getUserById(1);
		System.out.println(user);
	}
}
