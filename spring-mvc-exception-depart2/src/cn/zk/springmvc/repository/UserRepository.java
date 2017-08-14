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
		//��Ԫ���ʽ 
		/*
		 * users.size() > 0 Ϊtrue ���� users.get(0)
		 * users.size() > 0 Ϊfalse ����null
		 * Ҳ����˵ ��ǰ��ı�ʾ�ж����� 
		 * �ж�����Ϊtrue�Ļ� ����ð��ǰ��� false�� ����ð�ź����
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
