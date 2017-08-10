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
		// 从默认的类路径下加载hibernate.properties
		Configuration configuration = new Configuration();
		configuration.addClass(User.class);
		configuration.addResource("./com/hibernate/demo/one/User.hbm.xml");
		// 创建sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 创建session对象
		Session session = sessionFactory.openSession();
		// 开启事务
		session.beginTransaction();
		session.save(new User("CC", "13636210123", new Date(System.currentTimeMillis())));
		/*
		 * User user = session.get(User.class, 3); System.out.println(user);
		 */
		// 提交事务
		session.getTransaction().commit();
		// 关闭session
		session.close();
		// 关闭sessionfactory
		sessionFactory.close();
	}

	@Test
	public void testSessionFactoryOne() {
		// 从默认的类路径下加载hibernate.cfg.xml
		Configuration configuration = new Configuration().configure();
		// 创建sessionfactory
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		// 创建session对象
		Session session = sessionFactory.openSession();
		// 开启事务
		session.beginTransaction();
		// session.save(new User("BB", "13636210123", new
		// Date(System.currentTimeMillis())));
		User user = session.get(User.class, 3);
		System.out.println(user);
		// 提交事务
		session.getTransaction().commit();
		// 关闭session
		session.close();
		// 关闭sessionfactory
		sessionFactory.close();
	}

	@Test
	public void testSessionFactoryTwo() {

		// 从默认的类路径下加载hibernate.cfg.xml
		ServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		// 创建sessionfactory
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		// 创建session对象
		Session session = sessionFactory.openSession();
		// 开启事务
		session.beginTransaction();
		// 执行保存操作
		// session.save(new User("AA", "13636210123", new
		// Date(System.currentTimeMillis())));
		User user = session.get(User.class, 1);
		System.out.println(user);
		// 提交事务
		session.getTransaction().commit();
		// 关闭session
		session.close();
		// 关闭sessionfactory
		sessionFactory.close();
	}
}
