package com.mybatis.demo.test;

import java.io.IOException;
import java.io.InputStream;
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

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.dao.UserResultMap;
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

	/*@Test
	public void test() throws IOException{
		User user=sqlSession.selectOne("com.mybatis.demo.UserMapper.selectUser", 1);
		System.out.println(user);
	}*/
	
	
	@Test
	public void testInterface(){
		UserMapper uMapper=sqlSession.getMapper(UserMapper.class);
		User user=uMapper.getUserById(1);
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
	/**
	 * 多参数 命名参数测试
	 */
	@Test
	public void testParameter(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user=mapper.getUserByIdAndName(1, "root");
		
		System.out.println(user);
	}
	/**
	 * map参数测试
	 */
	@Test
	public void testMap(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("name", "root");
		User user=mapper.getUserByMap(map);
		
		System.out.println(user);
	}
	/**
	 * ......
	 */
	@Test
	public void testGetUserWithTable(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> map=new HashMap<>();
		map.put("id", 1);
		map.put("name", "root");
		map.put("tableName", "User");
		User user=mapper.getUserByMap(map);
		
		System.out.println(user);
	}
	
	/**
	 * 查询结果集list
	 */
	@Test
	public void testGetUserList(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		List<User> users=mapper.getUserList("root");
		for(User user:users){
			System.out.println(user);
		}
	}
	
	@Test
	public void testGetUserSingleMap(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<String, Object> userMap = mapper.getUserSingleMap(1);
		System.out.println(userMap);
	}
	
	@Test
	public void testGetUserManyMap(){
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		Map<Integer, User> userMap = mapper.getUserManyMap("root");
		System.out.println(userMap);
	}
	
	@Test
	public void testResultMap(){
		UserResultMap userResultMap=sqlSession.getMapper(UserResultMap.class);
		User user = userResultMap.getUserById(1);
		System.out.println(user);
	}
}
