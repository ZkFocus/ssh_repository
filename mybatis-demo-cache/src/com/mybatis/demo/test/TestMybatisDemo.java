package com.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.entity.User;

public class TestMybatisDemo {

	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	
	/**
	 * sqlSession级别的缓存  一级缓存 
	 * 失效的情况：
	 * 	对同一个查询对象来说
	 * 	①：清除缓存
	 * 	②：不同的openSession
	 *  ③：改变数据表内容的时候，执行增删改 
	 * @throws IOException 
	 */
	@Test
	public void testCacheLevelOne() throws IOException{
		SqlSession openSession = getSqlSessionFactory().openSession(true);
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);
		//执行增删改的时候
		User updateUser =new User(1,"admin110", "110");
		mapper.updateUser(updateUser);
		//mapper.addUser(insertUser);
		// 清除当前session的缓存
		//openSession.clearCache();
		User user2 = mapper.getUserById(1);
		System.out.println(user2);
		System.out.println(user==user2);
	}
	/**
	 * 二级缓存  基于namespace级别的
	 * 一个namespace对应一个二级缓存
	 * mybatis.xml 开启二级缓存
	 * XXXmapper.xml 配置二级缓存
	 * @throws IOException 
	 */
	@Test
	public void testCacheLevelTwo() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//创建4个openSession
		SqlSession openSession1 = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		SqlSession openSession3 = sqlSessionFactory.openSession();
		SqlSession openSession4 = sqlSessionFactory.openSession();
		
		//分别从4个openSession中获得UserMapper对象
		UserMapper mapper1 = openSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = openSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = openSession3.getMapper(UserMapper.class);
		UserMapper mapper4 = openSession4.getMapper(UserMapper.class);
		
		
		
		User user = mapper1.getUserById(3);
		System.out.println(user);
		//会话关闭或提交的时候 由一级缓存转移到二级缓存
		openSession1.close();
		
		User user2 = mapper2.getUserById(3);
		System.out.println(user2);
		openSession2.close();
		
		User user3 = mapper3.getUserById(3);
		System.out.println(user3);
		openSession3.close();
		
		
		User user4 = mapper4.getUserById(3);
		System.out.println(user4);
		openSession4.close();
		
		
		
		
	}
}
