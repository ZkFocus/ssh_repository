package com.ssh.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.ComponentType;

public class ComponentTypeRepository {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<ComponentType> getAll(){
		String hql =" from ComponentType ";
		return getSession().createQuery(hql).list();
	}
}
