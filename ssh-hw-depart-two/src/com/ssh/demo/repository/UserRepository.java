package com.ssh.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.User;
/**
 * Êý¾Ý·ÃÎÊ²ã
 * @author asus
 *
 */
public class UserRepository {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<User> getAllUser(){
		String hql="From User";
		return getSession().createQuery(hql).list();
	}
	public void delete(Integer id){
		String hql = "DELETE FROM User  WHERE id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	public void saveOrUpdate(User user){
		getSession().saveOrUpdate(user);
	}
	public User get(Integer id){
		return (User) getSession().get(User.class, id);
	}

	
} 
