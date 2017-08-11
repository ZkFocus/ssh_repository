package com.hp.hibernate.demo;

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
	
	
	private ServiceRegistry serviceRegistry;
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		 serviceRegistry=new StandardServiceRegistryBuilder().configure().build();
		 sessionFactory=new MetadataSources(serviceRegistry).
				 buildMetadata().buildSessionFactory();
		 session=sessionFactory.openSession();
		 transaction=session.beginTransaction();
	}
	
	@After
	public void destory(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	/**
	 * ��save����֮ǰ ָ��ID����Ч��
	 */
	@Test
	public void testSave(){
		User user =new User();
		user.setId(5);
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("FF");
		user.setTel("13836986532");
		//�������� �ﵽ���ݱ��Ŀ��
		session.save(user);
	}
	/**
	 * �ڵ��� persist ����֮ǰ, �������Ѿ��� id ��, �򲻻�ִ�� INSERT, ���׳��쳣
	 * javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: 
	 * detached entity passed to persist: com.hp.hibernate.demo.User
	 */
	@Test
	public void testPersist(){
		User user =new User();
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("AA");
		user.setTel("13836986532");
		user.setId(7);
		session.persist(user);
	}
	
	
	@Test
	public void testGetAndLoad(){
		User user=session.get(User.class, 2);
		System.out.println(user);
//		System.out.println(session.get(User.class, 2));
		/*User user2=session.load(User.class, 8);
		System.out.println(user2);*/
		
	}
	

	/**
	 * ��ͬһsession�½��в�������� ������Ϊ�ύ֮ǰ���޸�session�еĶ�������ԵĻ�
	 * �������ύ��ʱ�򣬻�ִ��һ��session.flush��������session�Ķ������Եı仯
	 * ���µ����ݱ���
	 */
	@Test 
	public void testSessionUpdate1(){
		User user=session.get(User.class, 1);
		user.setName("CCccc");
	}
	
	/**
	 * �¿���session��idΪ2��User�Ķ��󣬲���ͬһsession�¹����޸Ĳ�����������µ����ݿ���
	 */
	@Test
	public void testSessionUpdate2(){
		User user = session.get(User.class, 2);
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		user.setName("DD");
	}
	
	
	
	@Test
	public void testDelete(){
		User user=session.get(User.class, 1);
		System.out.println(user);
		session.delete(user);
		System.out.println(user);
		session.save(user);
	}
	
	/**
	 * session��һ������
	 */
	@Test
	public void testSessionCache(){
		//��һ�δ����ݿ��л�ȡ���� ����select���
		User user=session.get(User.class, 3);
		System.out.println(user);
		//���session���Ѿ����˸ö��� �ٴλ�ȡ�Ļ� �����ٷ���sql���
		User user2=session.get(User.class, 3);
		System.out.println(user2);
		//��֤�Ƿ��Ǵ�session�л�ȡ�Ķ��� �ж�����user1�Ƿ����user2 
		System.out.println(user==user2);
	}
	/**
	 * ��ʱ���˽�
	 */
	@Test
	public void testFlush(){
		User user=session.get(User.class, 2);
		user.setTel("190");
		session.remove(user);
		String hql="From User where id = ?";
		User user2=session.createQuery(hql,User.class).setInteger(0, 2).getSingleResult();
		System.out.println(user2);
	}
	/**
	 * ��ʱ���˽�
	 */
	@Test
	public void testClear(){
		User user=session.get(User.class, 2);
		System.out.println(user);
		
		session.clear();
		User user2=session.get(User.class, 2);
		System.out.println(user2);
	}
	/**
	 * ��ʱ�˽�  ����PPT��ʵ��
	 *  ��Ҫ��mysql���ݿ� ִ��������뼶��
	 *  set global transaction isolation level read committed;
	 */
	@Test
	public void testRefresh(){
		User user=session.get(User.class, 7);
		System.out.println(user);
		
		session.refresh(user);
		System.out.println(user);
	}

}
