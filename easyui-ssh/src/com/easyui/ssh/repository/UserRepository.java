package com.easyui.ssh.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.easyui.ssh.entity.User;

public class UserRepository {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public void saveOrUpdate(User user){
		this.getSession().saveOrUpdate(user);
	}
}
