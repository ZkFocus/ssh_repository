package com.hibernate.demo.o2o.primary;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestO2O {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init() {
		// 从默认的类路径下加载hibernate.cfg.xml
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}

	@After
	public void destroy() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	public void testDelete(){
	}
	
	@Test
	public void testGet2(){
		Manager manager=session.get(Manager.class, 1);
		System.out.println(manager.getMgrName());
	}
	
	@Test
	public void testGet(){
		Department department =session.get(Department.class, 1);
		System.out.println(department.getDeptName());
		
		Manager manager=department.getManager();
		System.out.println(manager.getMgrName());
	}
	
	@Test
	public void testSave(){
		
		Department department=new Department();
		department.setDeptName("DEPT_CC");
		
		Manager manager=new Manager();
		manager.setMgrName("CC");
		
		department.setManager(manager);
		manager.setDept(department);
		
		session.save(department);
		session.save(manager);
	}
	

}
