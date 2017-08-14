package cn.zk.springmvc.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.zk.springmvc.entity.User;

@Repository
public class UserRepository{
	
	@Autowired
	private JdbcOperations jdbcOperations;
	public User get(Integer id){
		String sql = "SELECT id, name , tel FROM user WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
		List<User> userList = jdbcOperations.query(sql, rowMapper, id);
		return userList.size()>0 ? userList.get(0) : null;
	}
}
