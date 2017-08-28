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
	 * sqlSession����Ļ���  һ������ 
	 * ʧЧ�������
	 * 	��ͬһ����ѯ������˵
	 * 	�٣��������
	 * 	�ڣ���ͬ��openSession
	 *  �ۣ��ı����ݱ����ݵ�ʱ��ִ����ɾ�� 
	 * @throws IOException 
	 */
	@Test
	public void testCacheLevelOne() throws IOException{
		SqlSession openSession = getSqlSessionFactory().openSession(true);
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = mapper.getUserById(1);
		System.out.println(user);
		//ִ����ɾ�ĵ�ʱ��
		User updateUser =new User(1,"admin110", "110");
		mapper.updateUser(updateUser);
		//mapper.addUser(insertUser);
		// �����ǰsession�Ļ���
		//openSession.clearCache();
		User user2 = mapper.getUserById(1);
		System.out.println(user2);
		System.out.println(user==user2);
	}
	/**
	 * ��������  ����namespace�����
	 * һ��namespace��Ӧһ����������
	 * mybatis.xml ������������
	 * XXXmapper.xml ���ö�������
	 * @throws IOException 
	 */
	@Test
	public void testCacheLevelTwo() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		
		//����4��openSession
		SqlSession openSession1 = sqlSessionFactory.openSession();
		SqlSession openSession2 = sqlSessionFactory.openSession();
		SqlSession openSession3 = sqlSessionFactory.openSession();
		SqlSession openSession4 = sqlSessionFactory.openSession();
		
		//�ֱ��4��openSession�л��UserMapper����
		UserMapper mapper1 = openSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = openSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = openSession3.getMapper(UserMapper.class);
		UserMapper mapper4 = openSession4.getMapper(UserMapper.class);
		
		
		
		User user = mapper1.getUserById(3);
		System.out.println(user);
		//�Ự�رջ��ύ��ʱ�� ��һ������ת�Ƶ���������
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
