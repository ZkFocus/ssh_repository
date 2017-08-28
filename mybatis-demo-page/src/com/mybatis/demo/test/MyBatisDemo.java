package com.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mybatis.demo.dao.UserMapper;
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
	public void testGetUsers() throws IOException{
		SqlSession openSession = getSqlSessionFactory().openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		PageHelper.startPage(2, 2);
		List<User> users = mapper.getUsers();
		for(User user:users){
			System.out.println(user);
		}
		openSession.close();
	}

}
