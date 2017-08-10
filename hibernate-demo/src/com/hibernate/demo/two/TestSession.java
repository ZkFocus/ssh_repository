package com.hibernate.demo.two;

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

public class TestSession {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init() {
		// ��Ĭ�ϵ���·���¼���hibernate.cfg.xml
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
	public void testCompont(){
		User user=new User();
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("AA");
		user.setTel("120");
		Address address=new Address();
		address.setCity("֣��");
		address.setStreet("��ѧ·");
		address.setProvince("����");
		user.setAddress(address);
		session.save(user);
	}
	

}
