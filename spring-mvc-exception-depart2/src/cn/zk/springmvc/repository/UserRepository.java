package cn.zk.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.zk.springmvc.entity.User;
@Repository
public class UserRepository {

	@Autowired
	private JdbcOperations jdbc;
	
	public User getUserById(int id){
		String sql ="select * from user where id = ?";
		RowMapper<User> mapper=new BeanPropertyRowMapper<>(User.class);
		List<User> users= jdbc.query(sql, mapper,id);
		//三元表达式 
		/*
		 * users.size() > 0 为true 返回 users.get(0)
		 * users.size() > 0 为false 返回null
		 * 也就是说 ？前面的表示判断条件 
		 * 判断条件为true的话 返回冒号前面的 false的 返回冒号后面的
		 */
		/**
		if(users.size()>0){
			return users.get(0)
		}else{
			return null;
		}
		*/
		return users.size() > 0 ? users.get(0) : null;
	}
}
