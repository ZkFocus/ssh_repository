package com.hibernate.demo.three;

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

public class TestN21 {

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
	public void test(){
		
	}
	@Test
	public void testDelete(){
		Customer customer=session.get(Customer.class, 1);
		session.delete(customer);
	}
	
	@Test
	public void testUpdate(){
		Order order=session.get(Order.class, 1);
		order.getCustomer().setName("update");
	}
	/**
	 * ���漰��������������� getҲ��������
	 */
	@Test
	public void testGet(){
		Order order=session.get(Order.class, 1);
//		System.out.println(order.getOrderNo());
		System.out.println(order.getCustomer());
	}
	
	@Test
	public void testSave(){
		Customer customer=new Customer();
		customer.setName("CC");
		
		Order order=new Order();
		order.setOrderNo("1001_CC");
		//���ù�����ϵ
		order.setCustomer(customer);
		
		Order order2=new Order();
		order2.setOrderNo("1002_CC");
		//���ù�����ϵ
		order2.setCustomer(customer);
		
		/**
		 * �����ȱ���1�˶��������Ļ���N�˶����ڲ����ʱ�� hibernate�Ѿ�
		 * ֪������е�ֵ
		 */
		
		session.save(order);
		session.save(order2);
		
		session.save(customer);
		
		
		
		
	}
	

}
