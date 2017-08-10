package com.hibernate.demo.one;

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

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	@Before
	public void init() {
		// 从默认的类路径下加载hibernate.cfg.xml
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
	public void testDelete(){
		User user = session.get(User.class, 1);
		session.delete(user);
		System.out.println(user);
		session.save(user);
		System.out.println(user);
	}
	/**
	 * 
	 */
	@Test
	public void testUpdate(){
		User user = session.get(User.class, 1);
		transaction.commit();
		session.close();
		session=sessionFactory.openSession();
		transaction=session.beginTransaction();
		user.setName("BB");
		//此时user对象为游离对象，需要显式调用update方法
		session.update(user);
	}
	
	/**
	 * persist(): 也会执行 INSERT 操作
	 * 和 save() 的区别 : 
	 * 在调用 persist 方法之前, 若对象已经有 id 了, 则不会执行 INSERT, 而抛出异常
	 */
	@Test
	public void testPersist(){
		User user=new User();
		user.setName("DD");
		user.setTel("190");
		user.setId(100);
		user.setBirth(new Date(System.currentTimeMillis()));
		session.persist(user);
	}
	
	/**
	 * 1. 使一个临时对象变为持久化对象
	 * 2. 为对象分配 ID.
	 * 3. 在 save 方法之前的 id 是无效的
	 * 4. 持久化对象的 ID 是不能被修改的!
	 */
	@Test
	public void testSave(){
		User user=new User();
		user.setName("BB");
		user.setTel("110");
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setId(100);
		System.out.println(user);
		session.save(user);
//		user.setId(14);
//		System.out.println(user);
	}
	
	@Test
	public void testSessionClear(){
		User user = session.get(User.class, 1);
		System.out.println(user);
		session.clear();//clear之后将再次发送查询sql
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
	}
	
	@Test
	public void testSessionRefresh(){
		User user = session.get(User.class, 1);
		System.out.println(user);
		//调用refresh之前修改数据库记录，refresh操作则将发送select语句查询数据库
		//保证session中的记录与数据库中保持一致
		session.refresh(user);
		System.out.println(user);
	}
	
	@Test
	public void testSessionFlush(){
		/*User user = session.get(User.class, 6);
		session.remove(user);*/
		/*String hql="From User where id = ?";
		User user2=(User) session.createQuery(hql,User.class).setParameter(0, 1).getSingleResult();
		System.out.println(user2);*/
		
		User user=new User();
		user.setName("AA");
		user.setTel("190");
		user.setBirth(new Date(System.currentTimeMillis()));
		user.setId(100);
		System.out.println(user);
		session.save(user);
	}
	
	
	@Test
	public void testSessionCache() {
		User user = session.get(User.class, 1);
		System.out.println(user);
		//再次获取，会重新发送SQL吗？
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		System.out.println(user==user2);
	}

	

}
