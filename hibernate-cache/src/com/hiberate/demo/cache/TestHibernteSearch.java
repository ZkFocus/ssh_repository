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
		// 加载配置文件
		serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		// 创建sessionfactory
		sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
		// 开启session
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
	 * 在同一个session下执行的结果都会首先缓存到一级缓存中
		在同一个session下执行的结果都会首先缓存到一级缓存中

	 */
	@Test
	public void test2(){
		Query query=session.createQuery("select o From Order o");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		System.out.println("存放二级缓存的数量..."+sessionFactory.getStatistics().getSecondLevelCachePutCount());
		System.out.println("一级缓存存放实体的数量"+session.getStatistics().getEntityCount());
		
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Query query2=session.createQuery("select o From Order o");
		query2.setCacheable(true);
		List<Order> orders2=query2.list();
		System.out.println("二级缓存命中数量..."+sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println(orders2.size());

	}
	
	/**
	 * 查询缓存与二级缓存 对查询对象（属性与实体）的区别
	 */
	@Test
	public void test1(){
		Query query=session.createQuery("select o From Order o");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		System.out.println("存放二级缓存的数量..."+sessionFactory.getStatistics().getSecondLevelCachePutCount());
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Query query2=session.createQuery("select o From Order o");
		query2.setCacheable(true);
		List<Order> orders2=query2.list();
		System.out.println("二级缓存命中数量..."+sessionFactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println(orders2.size());

	}
	/**
	 * 自我探索
	 */
	@Test
	public void testTimeStampCache(){
		Query query=session.createQuery("From Order");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());

		//执行更新的操作
		Order order =session.get(Order.class, 1);
		order.setPrice(33.3f);
		
		//再次查询是否会调用SQL 
		orders=query.list();
		System.out.println(orders.size());

	}
	
	/**
	 * 在配置文件中配置开启查询缓存
	 * 设置query.setCacheable(true);
	 * 查询缓存依赖于二级缓存
	 */
	@Test
	public void testQueryCache(){
		Query query=session.createQuery("From Order");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		
		
		//关闭事务以及session
		transaction.commit();
		session.close();
		//重新开启事务及session
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
		
		//关闭事务以及session
		transaction.commit();
		session.close();
		//重新开启事务及session
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
		
		//关闭事务以及session
		transaction.commit();
		session.close();
		//重新开启事务及session
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		
		Order order2 =session.get(Order.class, 1);
		System.out.println(order2);
	}
}
