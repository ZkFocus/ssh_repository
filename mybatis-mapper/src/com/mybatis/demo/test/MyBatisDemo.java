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
	
	@Test
	public void testCURD(){
		/**
		 * UserMapper 可自定义CURD返回值
		 * sqlSessionFactory.openSession() 手动提交
		 * sqlSessionFactory.openSession(true) 自动提交
		 * 
		 */
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user =new User(null,"root","13600000001");
		/**
		 * 自增主键获取值 
		 * 映射文件设置 useGeneratedKeys="true" 
		 * 赋值给user的id属性 keyProperty="id"
		 */
		mapper.addUser(user);
		System.out.println(user.getId());
		/*mapper.updateUser(user);*/
		/*mapper.deleteUserById(2);*/
		
		sqlSession.commit();
		sqlSession.close();
	}
}
