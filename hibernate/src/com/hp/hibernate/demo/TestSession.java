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
	 * 在save方法之前 指定ID是无效的
	 */
	@Test
	public void testSave(){
		User user =new User();
		user.setId(5);
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setName("FF");
		user.setTel("13836986532");
		//操作对象 达到数据表的目的
		session.save(user);
	}
	/**
	 * 在调用 persist 方法之前, 若对象已经有 id 了, 则不会执行 INSERT, 而抛出异常
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
	 * 在同一session下进行操作对象的 在事务为提交之前，修改session中的对象的属性的话
	 * 在事务提交的时候，会执行一个session.flush操作，将session的对象属性的变化
	 * 更新到数据表中
	 */
	@Test 
	public void testSessionUpdate1(){
		User user=session.get(User.class, 1);
		user.setName("CCccc");
	}
	
	/**
	 * 新开启session后，id为2的User的对象，不再同一session下管理，修改操作将不会更新到数据库中
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
	 * session的一级缓存
	 */
	@Test
	public void testSessionCache(){
		//第一次从数据库中获取对象 发送select语句
		User user=session.get(User.class, 3);
		System.out.println(user);
		//如果session中已经有了该对象 再次获取的话 将不再发送sql语句
		User user2=session.get(User.class, 3);
		System.out.println(user2);
		//验证是否是从session中获取的对象 判断两个user1是否等于user2 
		System.out.println(user==user2);
	}
	/**
	 * 暂时先了解
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
	 * 暂时先了解
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
	 * 暂时了解  参照PPT做实验
	 *  需要对mysql数据库 执行事务隔离级别
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
