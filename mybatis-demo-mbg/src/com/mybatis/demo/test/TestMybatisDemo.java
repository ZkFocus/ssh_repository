package com.mybatis.demo.test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.entity.User;
import com.mybatis.demo.entity.UserExample;
import com.mybatis.demo.entity.UserExample.Criteria;

public class TestMybatisDemo {

	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testMBG() throws Exception {
		List<String> warnings = new ArrayList<String>();
		boolean overwrite = true;
		File configFile = new File("mbg.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(configFile);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		myBatisGenerator.generate(null);
	}
	/**
	 * xxxExample 用于封装查询条件
	 * @throws IOException
	 */
	@Test
	public void testCURD() throws IOException{
		SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		/*
		 * 封装查询条件 类似QBC
		 */
		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();
		criteria.andNameLike("roo%");
		
		//userExample.or(criteria2);
		
		List<User> list = mapper.selectByExample(userExample);
		for(User user:list){
			System.out.println(user);
		}
		
	}
}
