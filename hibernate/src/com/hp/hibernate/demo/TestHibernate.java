package com.hp.hibernate.demo;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class TestHibernate {

	@Test
	public void testHibernate(){
		//����·���¼���Ĭ�ϵ������ļ�
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		//����sessionfactory
		SessionFactory sessionFactory=new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		//��sessionfactory�л�ȡSession
		Session session =sessionFactory.openSession();
		//��������
		Transaction transaction=session.beginTransaction();
		
		User user=new User();
		user.setId(4);
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("AA");
		user.setTel("120");
		user.setAge(10);
		session.save(user);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
		
	}
	/**
	 * Ĭ�ϼ���hibernate.cfg.xml
	 */
	@Test
	public void test(){
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		sessionFactory.openSession();
		////
	}
	/**
	 * ����hibernate.properties
	 */
	@Test
	public void testProperties(){
		Configuration configuration=new Configuration();
		configuration.addClass(User.class);
		configuration.addResource("./com/hp/hibernate/demo/User.hbm.xml");
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		//��sessionfactory�л�ȡSession
		Session session =sessionFactory.openSession();
		//��������
		Transaction transaction=session.beginTransaction();
		
		User user=new User();
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("BB");
		user.setTel("120");
		
		session.save(user);
		
		transaction.commit();
		
		session.close();
		
		sessionFactory.close();
		
	}
}
