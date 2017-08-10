package com.hiberate.demo.search.style;


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
	 * ԭ��SQlʹ�÷�ʽ
	 * ͨ������session.createNativeQuery
	 */
	@Test
	public void testNativeSql(){
		String sql="select * from order_";
		List<Object[]> orders=session.createNativeQuery(sql).list();
		for (Object[] objects : orders) {
			
			System.out.println(Arrays.asList(objects));
		}
		
		String insert= "insert into customer_(name,email) values(?,?)";
		session.createNativeQuery(insert).setParameter(1, "Mac").setParameter(2, "mac@163.com").executeUpdate();

	}
	
	@Test
	public void testBC4(){
		Criteria criteria=session.createCriteria(Order.class);
		int pageNo=3;
		int pageSize=4;
		//��һ����¼��0��ʼ ��һҳ 0-3 �ڶ�ҳ4-7 ����ҳ8-11
		List<Order> order=criteria.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		System.out.println(order);
	}
	/**
	 * �����÷� 
	 * ͨ��org.hibernate.criterion.Order �ṩ��asc���� desc���������ø����ĸ��ֶ�������
	 */
	@Test
	public void testBC3(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.addOrder(org.hibernate.criterion.Order.asc("price"));
		System.out.println(criteria.list());
		List<Order> orders=(List<Order>) criteria.list();
		for (Order order2 : orders) {
			System.out.println(order2);
		}
	}
	
	@Test
	public void testBC2(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.setProjection(Projections.max("price"));
		System.out.println(criteria.uniqueResult());
	}
	/**
	 * Criteria�÷�һ 
	 *  select
        this_.ID as ID1_1_0_,
        this_.ORDERNO as ORDERNO2_1_0_,
        this_.PRICE as PRICE3_1_0_,
        this_.C_ID as C_ID4_1_0_ 
    from
        ORDER_ this_ 
    where
        this_.ORDERNO=?
	 * ������ѯ  = ��ѯ��ʽ      
	 * =�ڴ����б�ʾΪ Restrictions.eq 
	 *  
	 */
	@Test
	public void testQbc1(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderNo", "201705010008"));
		Order order=(Order) criteria.uniqueResult();
		System.out.println(order);
	}
	/**
	 * ����̽��
	 */
	@Test
	public void testFetch(){
		String hql="select distinct c From Customer c left join fetch  c.orders";
		Query query=session.createQuery(hql);
		List<Customer> customers=query.list();
		for (Customer customer : customers) {
			
			System.out.println(customer.getName()+"----"+customer.getOrders().size());
		}
	}
	
	/**
	 * ͶӰ��ѯ ��ȡ�������� ֱ����get��ʽ��ȡ
	 */
	@Test
	public void testPart() {
		String hql="select new com.hiberate.demo.search.style.Order(o.orderNo,o.price) From Order o where o.customer =:customer";
		Customer customer=new Customer();
		customer.setId(1);
		Query query=session.createQuery(hql).setParameter("customer", customer);
		List<Order> orders=query.list();
		for (Order order : orders) {
			System.out.println(order);
		}
		//Ĭ�Ϸ��ص���object���� �������ݲ����� 
		//select o.orderNo,o.price From Order o where o.customer =:customer
		/*List<Object[]> objects=query.list();
		for (Object[] objects2 : objects) {
			System.out.println(Arrays.asList(objects2));
		}*/
		

		
	}
	
	@Test
	public void testNameduery(){
		Query query=session.getNamedQuery("priceSelect").setParameter("minPrice", 40f).setParameter("maxPrice", 90f);
		List<Order> orders=query.list();
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	/**
	 * ��ҳ��ѯ
	 */
	@Test
	public void testPage(){
		String hql="From Order";
		Query query=session.createQuery(hql);
		int pageNo=3;	//����ҳ
		int pageSize=4; //ÿһҳ��������
		//��һ����¼��0��ʼ ��һҳ 0-3 �ڶ�ҳ4-7 ����ҳ8-11 ����ҳ��һ����¼��Ϊ12
		//pageNo*pageSize ���һ����¼ ��ȥ  -pageSize ÿһҳ������ 
		//setFirstResult ĳһҳ�ĵ�һ����¼ ��¼�Ŵ�0����
		//setMaxResults  ÿһҳ�ļ�¼��
		List<Order> orders=query.setFirstResult((pageNo*pageSize-pageSize)).setMaxResults(pageSize).list();
		System.out.println(orders);
	}
	
	/**
	 * hqlҲ֧�ֺ�����ʹ��
	 */
	@Test
	public void testHqlFun(){
		String hql="select min(o.price),o.customer from Order o group by o.customer having min(o.price)> ?";
		Query query=session.createQuery(hql).setParameter(0, 20f);
		List<Object[]> result=query.list();
		for (Object[] o : result) {
			System.out.println(Arrays.asList(o));
		}
	}
	
	/**
	 * HQL֧���Զ������͵Ĳ�������
	 */
	@Test
	public void testParameterEntity(){
		String hql="From Order o where o.customer = ?";
		Query query=session.createQuery(hql);
		Customer customer=new Customer();
		customer.setId(1);
		
		List<Order> orders=query.setParameter(0, customer).list();
		for (Order order : orders) {
			System.out.println(order);
		}
	}
	
	@Test
	public void testHQLParameter(){
		//����query���� ռλ���Ĳ�ѯ
		String hql="From Customer c where c.email like ?";
		Query query=session.createQuery(hql);
		//�󶨲��� 
		query.setParameter(0, "%a%");
		//ִ�в�ѯ
		List<Customer> customers= query.list();
		System.out.println(customers.size());
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		//���������Ĳ�ѯ 
		String namedHL="From Customer c where c.email like :email";
		List<Customer> cList=session.createQuery(namedHL).setParameter("email", "%g%").list();
		System.out.println("ռλ����"+cList.size());
	}
}
