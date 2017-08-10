package com.hibernate.demo.n2n.single;

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

public class TestN2N {

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
		
	}
	
	@Test
	public void testGet(){
		Category category=session.get(Category.class, 1);
		System.out.println(category.getName());
		
		Item item=category.getItems().iterator().next();
		System.out.println(item.getName());
	}
	
	@Test
	public void testSave(){
		Category category=new Category();
		category.setName("C_AA");
		
		Category category2=new Category();
		category2.setName("C_BB");
		
		Item item=new Item();
		item.setName("I-AA");
		
		Item item2=new Item();
		item2.setName("I-BB");
		
		category.getItems().add(item);
		category.getItems().add(item2);
		
		
		category2.getItems().add(item);
		category2.getItems().add(item2);
		
		session.save(category);
		session.save(category2);
		
		session.save(item);
		session.save(item2);
		
		
		
		
		
		
		
	}
	

}
