package com.zh.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.zh.dao.UserCustom;
import com.zh.dao.UserMapper;
import com.zh.dao.UserQueryVo;
import com.zh.model.User;

public class Tests {
	private SqlSessionFactory sqlSessionFactory;
	private SqlSession session;
	@Before
	public void getSession() throws IOException{
		String re="mybits_config.xml";
		InputStream inputStream = Resources.getResourceAsStream(re);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession(true);
	}
	@After
	public void col(){
		session.close();
	}
	/**
	 * 动态SQL if语句判断
	 */
	//if
	@Test
	public void getUserif(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setUname("张三");
		List<User> list = userMapper.getUserif(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	//ifs
	@Test
	public void getUserList(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo  = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setId(1);
		userCustom.setUname("张三");
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> customs= userMapper.getUserList(null);
		for (UserCustom userCustom2 : customs) {
			System.out.println(userCustom2);
		}
	}
	//choose, when, otherwise
	@Test
	public void getUserCWO(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setUname("张三");
		user.setUpass("123");
		List<User> list = userMapper.getUserCWO(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	//trim
	@Test
	public void getUserTrim(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(1);
		user.setUname("张三");
		user.setUpass("123");
		List<User> list = userMapper.getUserTrim(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
	//set  修改
	@Test
	public void getUserSet(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(6);
		user.setUname("宝马X6");
		user.setUpass("666666");
		int a = userMapper.updateUserBySet(user);
		if (a==1) {
			System.out.println("修改成功");  
		}
	}
	//set和trim配合使用       修改
	@Test
	public void getUserSetAndTrim(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setId(6);
		user.setUname("宝马Xmax");
		user.setUpass("666666");
		int a = userMapper.updateUserBySetAndTrim(user);
		if (a==1) {
			System.out.println("修改成功");  
		}
	}
	//foreach  参数为list
	@Test
	public void getUserForeachList(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		UserQueryVo userQueryVo  = new UserQueryVo();
		//传入多个lid
		List<Integer> lid = new ArrayList<Integer>();
		lid.add(1);
		lid.add(6);
		lid.add(10);
		//把lid放入userQueryVo中
		userQueryVo.setLid(lid);
		List<UserCustom> customs= userMapper.selectUserByForEachList(userQueryVo);
		for (UserCustom userCustom2 : customs) {
			System.out.println(userCustom2);
		}
	}
	//bind  模糊查询
	@Test
	public void getUserByUname(){
		UserMapper userMapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUname("大");
		List<User> list = userMapper.findUserByUname(user);
		for (User user2 : list) {
			System.out.println(user2);
		}
	}
}
