package com.hiberate.demo.cache;


import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestHibernteSearch {

	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void init() {
		// ���������ļ�
		serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// ����sessionfactory
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// ����session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	@After
	public void destroy(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * ��ͬһ��session��ִ�еĽ���������Ȼ��浽һ��������
		��ͬһ��session��ִ�еĽ���������Ȼ��浽һ��������

	 */
	@Test
	public void test2(){
		Query query=session.createQuery("select o From Order o");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		System.out.println("��Ŷ������������..."+sessionFactory.getStatistics().getSecondLevelCachePutCount());
		System.out.println("һ��������ʵ�������"+session.getStatistics().getEntityCount());
		
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Query query2=session.createQuery("select o From Order o");
		query2.setCacheable(true);
		List<Order> orders2=query2.list();
		System.out.println("����������������..."+sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println(orders2.size());

	}
	
	/**
	 * ��ѯ������������� �Բ�ѯ����������ʵ�壩������
	 */
	@Test
	public void test1(){
		Query query=session.createQuery("select o From Order o");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		System.out.println("��Ŷ������������..."+sessionFactory.getStatistics().getSecondLevelCachePutCount());
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query2=session.createQuery("select o From Order o");
		query2.setCacheable(true);
		List<Order> orders2=query2.list();
		System.out.println("����������������..."+sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println(orders2.size());

	}
	/**
	 * ����̽��
	 */
	@Test
	public void testTimeStampCache(){
		Query query=session.createQuery("From Order");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());

		//ִ�и��µĲ���
		Order order =session.get(Order.class, 1);
		order.setPrice(33.3f);
		
		//�ٴβ�ѯ�Ƿ�����SQL 
		orders=query.list();
		System.out.println(orders.size());

	}
	
	/**
	 * �������ļ������ÿ�����ѯ����
	 * ����query.setCacheable(true);
	 * ��ѯ���������ڶ�������
	 */
	@Test
	public void testQueryCache(){
		Query query=session.createQuery("From Order");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		
		
		//�ر������Լ�session
		transaction.commit();
		session.close();
		//���¿�������session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		orders=session.createQuery("From Order").setCacheable(true).list();
		System.out.println(orders.size());
	}
	
	@Test
	public void testCollectionCache(){
		Customer customer=session.get(Customer.class, 1);
		System.out.println(customer.getName());
		System.out.println(customer.getOrders().size());
		
		//�ر������Լ�session
		transaction.commit();
		session.close();
		//���¿�������session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Customer customer2=session.get(Customer.class, 1);
		System.out.println(customer2.getName());
		System.out.println(customer2.getOrders().size());
				
	}
	
	@Test
	public void testClassCache(){
		Order order =session.get(Order.class, 1);
		System.out.println(order);
		
		//�ر������Լ�session
		transaction.commit();
		session.close();
		//���¿�������session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Order order2 =session.get(Order.class, 1);
		System.out.println(order2);
	}
}
