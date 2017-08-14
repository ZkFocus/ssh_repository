package com.ssh.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.User;

public class UserRepository {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public List<User> getAll(){
		String hql="From User";
		return getSession().createQuery(hql).list();
	}
	
	public void saveOrUpdate(User user){
		this.getSession().saveOrUpdate(user);
	}
	public void delete(Integer id){
		String hql="Delete from User where id = ?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	public User get(Integer id ){
		return (User) this.getSession().get(User.class, id);
		 
	}
	
	public List<User> find(int page, int rows, Map<String, String> map) {

		List<User> list = new ArrayList<>();// 定义list变量并实例化

		String sql = "from User"; // 创建基础HQL语句

		String name = map.get("name");// 接收参数

		if (name != null && !name.equals(""))// 判断参数
		{
			sql += "and name =:name ";//
		}

		String tel = map.get("tel");

		if (tel != null && !tel.equals("")) {
			sql += "and tel =:tel ";
		}


		Query qu = sessionFactory.getCurrentSession().createQuery(sql);

		if (name != null && !name.equals("")) {
			qu.setString("name", name);
		}

		if (tel != null && !tel.equals("")) {
			qu.setString("tel", tel);
		}

		list = qu.setMaxResults(rows)// 每页行数
				.setFirstResult((page - 1) * rows)// 起始页码
				.list();

		return list;

	}
	
	public int findTotal(Map<String, String> map) {
		int rtn = 0;// 定义变量并赋值

		String sql = "select count(1) from Student where 1=1 ";

		String name = map.get("name");// 接收参数

		if (name != null && !name.equals(""))// 判断参数
		{
			sql += "and name =:name";//
		}

		String tel = map.get("tel");

		if (tel != null && !tel.equals("")) {
			sql += "and tel =:tel ";
		}

		Query qu = sessionFactory.getCurrentSession().createSQLQuery(sql); // 获取Query对象

		if (name != null && !name.equals("")) {
			qu.setString("name", name);
		}

		if (tel != null && !tel.equals("")) {
			qu.setString("tel", tel);
		}

		List<Object> list = qu.list();// 定义list变量并实例化

		if (list != null && list.size() > 0)// 判断获取的集合非空及长度
		{
			rtn = Integer.parseInt(list.get(0).toString());// 给变量rtn赋值
		}

		return rtn;// 返回变量值
	}
}
