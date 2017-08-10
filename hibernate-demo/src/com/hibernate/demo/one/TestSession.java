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
		//��ʱuser����Ϊ���������Ҫ��ʽ����update����
		session.update(user);
	}
	
	/**
	 * persist(): Ҳ��ִ�� INSERT ����
	 * �� save() ������ : 
	 * �ڵ��� persist ����֮ǰ, �������Ѿ��� id ��, �򲻻�ִ�� INSERT, ���׳��쳣
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
	 * 1. ʹһ����ʱ�����Ϊ�־û�����
	 * 2. Ϊ������� ID.
	 * 3. �� save ����֮ǰ�� id ����Ч��
	 * 4. �־û������ ID �ǲ��ܱ��޸ĵ�!
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
		session.clear();//clear֮���ٴη��Ͳ�ѯsql
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
	}
	
	@Test
	public void testSessionRefresh(){
		User user = session.get(User.class, 1);
		System.out.println(user);
		//����refresh֮ǰ�޸����ݿ��¼��refresh�����򽫷���select����ѯ���ݿ�
		//��֤session�еļ�¼�����ݿ��б���һ��
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
		//�ٴλ�ȡ�������·���SQL��
		User user2 = session.get(User.class, 1);
		System.out.println(user2);
		System.out.println(user==user2);
	}

	

}
