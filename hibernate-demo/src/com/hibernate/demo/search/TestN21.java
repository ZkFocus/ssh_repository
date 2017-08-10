package com.hibernate.demo.search;

import java.sql.Date;
import java.util.List;

import org.hibernate.Hibernate;
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
		Customer customer=session.get(Customer.class, 2);
		session.delete(customer);
	}
	
	
	@Test
	public void testSet(){
		
	}
	
	
	
	@Test
	public void testSave(){
		Customer customer=new Customer();
		customer.setName("EE");
		
		Order order=new Order();
		order.setOrderNo("1001_EE");
		order.setCustomer(customer);
		
		Order order2=new Order();
		order2.setOrderNo("1002_EE");
		order2.setCustomer(customer);
		
		
		Order order3=new Order();
		order3.setOrderNo("1003_EE");
		order3.setCustomer(customer);
		
		
		
		Order order4=new Order();
		order4.setOrderNo("1004_EE");
		order4.setCustomer(customer);
		
		
		Order order5=new Order();
		order5.setOrderNo("1005_EE");
		order5.setCustomer(customer);
		
		Order order6=new Order();
		order6.setOrderNo("1006_EE");
		order6.setCustomer(customer);
		
		Order order7=new Order();
		order7.setOrderNo("1007_EE");
		order7.setCustomer(customer);
		
		customer.getOrders().add(order);
		customer.getOrders().add(order2);
		customer.getOrders().add(order3);
		customer.getOrders().add(order4);
		customer.getOrders().add(order5);
		customer.getOrders().add(order6);
		customer.getOrders().add(order7);
		
		
		session.save(customer);
		session.save(order);
		session.save(order2);
		session.save(order3);
		session.save(order4);
		session.save(order5);
		session.save(order6);
		session.save(order7);
		
		
		
	}
	
	
	
	
	@Test
	public void teaqw(){
		List<Order> orders=session.createQuery("From Order o ").list();
		for(Order order:orders){
		System.out.println(order.getCustomer().getName());
		}

	}
	
	
	
	
	@Test
	public void test(){
		
		List<Customer> customers=session.createQuery("From Customer").list();
		System.out.println(customers.size());
		
		for(Customer customer:customers){
			System.out.println(customer.getOrders().size());
		}
	}
	
	@Test
	public void test2(){
		
		List<Order> orders=session.createQuery("From Order o ").list();
		for(Order order:orders){
			System.out.println(order.getCustomer().getName());
		}
	}
	
}
