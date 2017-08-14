package com.hp.easyui.demo.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.hp.easyui.demo.entity.User;

public class UserRepository {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(User user){
		sessionFactory.getCurrentSession().save(user);
	}
	public List<User> getAll(){
		String hql="From User";
		List<User> userList=sessionFactory.getCurrentSession().createQuery(hql).list();
		return userList;
	}
	public List<User> getPageList(String page,String rows){
		//page 就是当前页
		int currentPage=Integer.valueOf(page);
		//rows 就是每一页的大小
		int pageSize=Integer.valueOf(rows);
		//每一页的起始值
		int offSet=pageSize*(currentPage-1);
		//方法链编程风格
		List<User> userList=sessionFactory.getCurrentSession().createQuery("From User")
			.setFirstResult(offSet)
			.setMaxResults(pageSize)
			.list();
		return userList;
	}
}
