package com.ssh.demo.repository;

import java.util.List;

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
}
