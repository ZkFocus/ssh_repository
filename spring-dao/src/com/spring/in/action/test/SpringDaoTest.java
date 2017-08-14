package com.spring.in.action.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.in.action.config.DataSourceConfig;
import com.spring.in.action.entity.User;
import com.spring.in.action.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=DataSourceConfig.class)
public class SpringDaoTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JdbcOperations jdbcOperations;
	
	@Autowired
	private NamedParameterJdbcOperations namedParameterJdbcOperations;
	
	
	@Test
	public void testUserRepository(){
		System.out.println(userRepository.get(1));
	}
	
	
	 //执行 INSERT, UPDATE, DELETE
	@Test
	public void save() {
		String sql ="insert into user(name,tel) values(?,?)";
		jdbcOperations.update(sql,"abcd","13698651236");
	}
	//获取总数 
	@Test
	public void getCount(){
		String sql="select count(*) from user";
		Long count=jdbcOperations.queryForObject(sql, Long.class);
		System.out.println(count);
	}
	//获取单列
	@Test
	public void getProperty(){
		String sql="select name from user where id  =?";
		String name=jdbcOperations.queryForObject(sql, String.class, 5);
		System.out.println(name);
	}
	//通过RowMapper接口 映射对象
	@Test
	public void getUser() {
		String sql="select id,name,tel from user where id =?";
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
		User user=jdbcOperations.queryForObject(sql, rowMapper, 3);
		System.out.println(user);
	}
	
	/**
	 * 执行批量更新: 批量的 INSERT, UPDATE, DELETE
	 */
	@Test
	public void batchSave() {
		String sql ="insert into user (name,tel) values (?,?)";
		List<Object[]> args=new ArrayList<>();
		args.add(new Object[]{"AA","12345678900"});
		args.add(new Object[]{"BB","12345678900"});
		args.add(new Object[]{"CC","12345678900"});
		args.add(new Object[]{"DD","12345678900"});
		args.add(new Object[]{"EE","12345678900"});
		args.add(new Object[]{"FF","12345678900"});
		jdbcOperations.batchUpdate(sql, args);
	}	
	/**
	 * 查到实体类的集合
	 * 注意调用的不是 queryForList 方法
	 */
	@Test
	public void queryBatch() {
		String sql="select id,name,tel from user where id >?";
		RowMapper<User> rowMapper=new BeanPropertyRowMapper<>(User.class);
		List<User> users=jdbcOperations.query(sql, rowMapper,3);
		System.out.println(users);
	}
	/**
	 * 可以为参数起名字. 
	 * 若有多个参数, 则不用再去对应位置, 直接对应参数名, 便于维护
	 */
	@Test
	public void testNamedParamerd() {
		String sql ="insert into user (name,tel) values (:name,:tel)";
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", "FF");
		paramMap.put("tel", "13823659815");
		namedParameterJdbcOperations.update(sql, paramMap);
	}
}
