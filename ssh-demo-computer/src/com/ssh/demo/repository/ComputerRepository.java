package com.ssh.demo.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.Computer;

public class ComputerRepository {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	
	/*public List<Computer> getPage(int offset,int pageSize){
		Query query=getSession().createQuery("From Computer");

		List<Computer> computers = query.setFirstResult(offset).setMaxResults(pageSize).list();
		return computers;
	}*/
	public List<Computer> getAllComputer(){
		String hql="From Computer ";
		return getSession().createQuery(hql).list();
	}
	
	
	public void delete(Integer id){
		String hql = "DELETE FROM Computer  WHERE id = ?";
		getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	
	
	public void saveOrUpdate(Computer computer){
		getSession().saveOrUpdate(computer);
	}
	
	
	public Computer get(Integer id){
		return (Computer) getSession().get(Computer.class, id);
	}
}
