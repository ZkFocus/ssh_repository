package cn.zk.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.zk.springmvc.model.User;

@Repository
public class UserRepository {

	@Autowired
	private JdbcOperations jdbc;
	
	public List<User> getAllUser(){
		String sql ="select * from users";
		RowMapper<User> rowMapper=
					new BeanPropertyRowMapper<>(User.class);
		List<User> userList = jdbc.query(sql, rowMapper);
		return userList.size() > 0 ? userList : null;
	}
	
	public User getUserByName(String name){
		String sql="select * from users where name= ? ";
		RowMapper<User> rowMapper =new BeanPropertyRowMapper<>(User.class);
		User user=jdbc.queryForObject(sql, rowMapper);
		return user;
	}
}
