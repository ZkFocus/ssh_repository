package com.hibernate.demo.threeboth;

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

public class TestN21 {

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
		Customer customer=session.get(Customer.class, 4);
		session.delete(customer);
	}
	
	@Test
	public void test(){
		
	}
	
	@Test
	public void testGet(){
		Customer customer=session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	@Test
	public void testSave(){
		Customer customer=new Customer();
		customer.setName("HH");
		
		Order order=new Order();
		order.setOrderNo("1001_HH");
		order.setCustomer(customer);
		
		Order order2=new Order();
		order2.setOrderNo("1002_HH");
		order2.setCustomer(customer);
		
		customer.getOrders().add(order);
		customer.getOrders().add(order2);
		
		session.save(customer);
/*
		session.save(order);
		session.save(order2);*/


		
		
	}
	

}
