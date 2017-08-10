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
		// ����hibernate�����ļ�
		// A SessionFactory is set up once for an application!
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // configures
																							// settings
																							// from
																							// hibernate.cfg.xml
				.build();
		//���sessionfactory
		SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		//����һ��session
		Session session = sessionFactory.openSession();
		//��������
		session.beginTransaction();
		
		//ͨ��session�������� ���ﵽ�������ݵ�Ŀ��
		User user=new User();
		user.setAge(23);
		user.setName("AA");
		session.save(user);
		
		//�����ύ
		session.getTransaction().commit();
		//session�ر�
		session.close();
		sessionFactory.close();

	}
}
