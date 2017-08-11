package com.ssh.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.User;

public class UserRepository{

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	public List<User> getAllUser(){
		String hql="From User";
		return this.getSession().createQuery(hql).list();
	}
}
