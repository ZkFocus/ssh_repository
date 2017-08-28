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

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.entity.User;

import tk.mybatis.mapper.code.Style;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Config;
import tk.mybatis.mapper.mapperhelper.MapperHelper;

public class MyBatisDemo {
	
	public SqlSessionFactory getSqlSessionFactory() throws IOException{
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testGetUsers() throws IOException{
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		MapperHelper mapperHelper = new MapperHelper();
		//特殊配置
		Config config = new Config();
		//具体支持的参数看后面的文档
		config.setStyle(Style.camelhump);
		//设置配置
		mapperHelper.setConfig(config);
		// 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
		mapperHelper.registerMapper(Mapper.class);
		//配置完成后，执行下面的操作
		mapperHelper.processConfiguration(sqlSession.getConfiguration());
		
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		
		List<User> list = mapper.selectAll();
		for(User user:list){
			System.out.println(user);
		}
	}

}
