package com.hibernate.demo.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Test;

public class TestHibernateHelloWorld {

	@Test
	public void testHelloWorld() {
		// 加载hibernate配置文件
		// A SessionFactory is set up once for an application!
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
																							// settings
																							// from
																							// hibernate.cfg.xml
				.build();
		//获得sessionfactory
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		//开启一个session
		Session session = sessionFactory.openSession();
		//开启事务
		session.beginTransaction();
		
		//通过session操作对象 来达到操作数据的目的
		User user=new User();
		user.setAge(23);
		user.setName("AA");
		session.save(user);
		
		//事务提交
		session.getTransaction().commit();
		//session关闭
		session.close();
		sessionFactory.close();

	}
}
