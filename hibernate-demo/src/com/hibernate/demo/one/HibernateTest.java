package com.hibernate.demo.one;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

public class HibernateTest {

	

	@Test
	public void testProperties() {
		// ��Ĭ�ϵ���·���¼���hibernate.properties
		Configuration configuration = new Configuration();
		configuration.addClass(User.class);
		configuration.addResource("./com/hibernate/demo/one/User.hbm.xml");
		// ����sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// ����session����
		Session session = sessionFactory.openSession();
		// ��������
		session.beginTransaction();
		session.save(new User("CC", "13636210123", new Date(System.currentTimeMillis())));
		/*
		 * User user = session.get(User.class, 3); System.out.println(user);
		 */
		// �ύ����
		session.getTransaction().commit();
		// �ر�session
		session.close();
		// �ر�sessionfactory
		sessionFactory.close();
	}

	@Test
	public void testSessionFactoryOne() {
		// ��Ĭ�ϵ���·���¼���hibernate.cfg.xml
		Configuration configuration = new Configuration().configure();
		// ����sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// ����session����
		Session session = sessionFactory.openSession();
		// ��������
		session.beginTransaction();
		// session.save(new User("BB", "13636210123", new
		// Date(System.currentTimeMillis())));
		User user = session.get(User.class, 3);
		System.out.println(user);
		// �ύ����
		session.getTransaction().commit();
		// �ر�session
		session.close();
		// �ر�sessionfactory
		sessionFactory.close();
	}

	@Test
	public void testSessionFactoryTwo() {

		// ��Ĭ�ϵ���·���¼���hibernate.cfg.xml
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// ����sessionfactory
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		// ����session����
		Session session = sessionFactory.openSession();
		// ��������
		session.beginTransaction();
		// ִ�б������
		// session.save(new User("AA", "13636210123", new
		// Date(System.currentTimeMillis())));
		User user = session.get(User.class, 1);
		System.out.println(user);
		// �ύ����
		session.getTransaction().commit();
		// �ر�session
		session.close();
		// �ر�sessionfactory
		sessionFactory.close();
	}
}
