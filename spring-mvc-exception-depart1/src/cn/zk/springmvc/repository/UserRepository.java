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
	
	public User getUser(int id){
		String sql ="select * from user where id = ?";
		RowMapper<User> rowMapper=
					new BeanPropertyRowMapper<>(User.class);
		List<User> userList = jdbc.query(sql, rowMapper, id);
		//��Ԫ���ʽ  a ? b : c
		//���aΪtrue �򷵻�b ��aΪfalse �򷵻�false
		/*if(userList.size()>0){
			return userList.get(0);
		}else{
			return null;
		}*/
		return userList.size() > 0 ? userList.get(0) : null;
	}
}
