package com.hibernate.demo.hql;

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

import net.sf.ehcache.hibernate.HibernateUtil;

public class TestHQL {

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
	public void testTimeCache(){
		Query query=session.createQuery("From Order");
		query.setCacheable(true);
		List<Order> orders=query.list();
		System.out.println(orders.size());
		
		Order order =session.get(Order.class, 1);
		order.setPrice(33.3f);
		
		orders=query.list();
		System.out.println(orders.size());
	}
	
	@Test
	public void testQueryCache(){
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
	
	@Test
	public void testCollectionCache(){
		Customer customer=session.get(Customer.class, 1);
		System.out.println(customer.getName());
		System.out.println(customer.getOrders().size());
		
		transaction.commit();
		session.close();

		
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Customer customer2=session.get(Customer.class, 1);
		System.out.println(customer2.getName());
		System.out.println(customer2.getOrders().size());
	}
	
	@Test
	public void testSecondLevelCache(){
		Order order=session.get(Order.class, 1);
		System.out.println(order);
		transaction.commit();
		session.close();
		
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		Order order2=session.get(Order.class, 1);
		System.out.println(order2);
		
		
	}
	
	@Test 
	public void testNativeSQL(){
		String sql="select * from order_";
		List<Object[]> orders= session.createNativeQuery(sql).list();
		for(Object[] order:orders){
			System.out.println(Arrays.asList(order));
		}
		
		String insert= "insert into customer_(name,email) values(?,?)";
		session.createNativeQuery(insert).setParameter(1, "Bird").setParameter(2, "bird@163.com").executeUpdate();
	}
	
	@Test
	public void testPage(){
		Criteria criteria=session.createCriteria(Order.class);
		// 第三页
		int pageNo = 3;
		// 每页4条数据
		int pageSize = 4;
		// 第一条记录从0开始（对应数据库ID为1）第一页 0-3 第二页4-7 第三页8-11
		List<Order> orders = criteria.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		System.out.println(orders);
	}

	/**
	 * 排序
	 */
	@Test
	public void testQBC3(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.addOrder(org.hibernate.criterion.Order.asc("price"));
		System.out.println(criteria.list());
	}
	
	/**
	 * 统计查询 使用Projections
	 */
	@Test
	public void testQBC2(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.setProjection(Projections.max("price"));
		System.out.println(criteria.uniqueResult());
	}
	
	
	@Test
	public void testQBC(){
		Criteria criteria=session.createCriteria(Order.class);
		criteria.add(Restrictions.eq("orderNo", "201705010005")); 
		Order order=(Order) criteria.uniqueResult();
		System.out.println(order);
	}
	
	@Test
	public void testFetch(){
		String hql = "select distinct c From Customer c LEFT JOIN FETCH c.orders";
		Query<Customer> query = session.createQuery(hql);
		
		List<Customer> customers = query.list();
		System.out.println( customers.size());
		for(Customer c:customers){
			System.out.println(c.getName()+"--"+c.getOrders().size());
		}
	}
	
	@Test
	public void testFunction(){
		String hql="select min(o.price),o.customer from Order o group by o.customer having min(o.price) > :minPrice";
		Query query=session.createQuery(hql);
		List<Object[]> result=query.setParameter("minPrice", 20.0f).list();
		for(Object[] o:result){
			System.out.println(Arrays.asList(o));
		}
	}
	
	@Test
	public void testField(){
		String hql="select new com.hibernate.demo.hql.Order(o.orderNo,o.price) from Order o  where o.customer = :customer";
		Query query=session.createQuery(hql);
		Customer customer = new Customer();
		customer.setId(1);
		List<Order> result=query.setParameter("customer", customer).list();
		for(Order o:result){
			System.out.println(o.getId()+"--"+o.getOrderNo()+"--"+o.getPrice());
		}
	}
	
	@Test
	public void test(){
		String hql ="select o.orderNo,o.price from Order o where o.customer=:customer";
		Query query=session.createQuery(hql);
		Customer customer = new Customer();
		customer.setId(1);
		List<Object[]> result=query.setParameter("customer", customer).list();
		for(Object[] o:result){
			System.out.println(Arrays.asList(o));
		}
	}
	
	@Test
	public void testNamedQuery() {
		Query query = session.getNamedQuery("priceQuery");
		List<Order> orders = query.setParameter("minPrice", 15.0f)
								  .setParameter("maxPrice", 90.0f)
								  .list();
		System.out.println(orders);
	}

	@Test
	public void testHQL_Page() {
		String hql = "From Order";
		Query query = session.createQuery(hql);
		// 第三页
		int pageNo = 3;
		// 每页4条数据
		int pageSize = 4;
		// 第一条记录从0开始（对应数据库ID为1）第一页 0-3 第二页4-7 第三页8-11
		List<Order> orders = query.setFirstResult((pageNo - 1) * pageSize).setMaxResults(pageSize).list();
		System.out.println(orders);
	}

	@Test
	public void testHQL_OrderBy() {
		// HQL 支持order by等函数
		String hql = "From Order o  where o.customer = ? ORDER BY o.price";

		// setParameter() 还支持实体类型
		Customer customer = new Customer();
		customer.setId(1);

		List<Order> orders = session.createQuery(hql).setParameter(0, customer).list();
		System.out.println(orders);
	}

	@Test
	public void testHQL() {
		// 1,创建query对象
		String hql = "From Customer c where c.email like ?";
		Query<Customer> query = session.createQuery(hql);
		// 2,绑定参数
		query.setParameter(0, "%d%");
		// 3,执行查询
		List<Customer> customers = query.list();
		System.out.println("占位符查询：" + customers.size());

		String namedHQL = "From Customer c where c.email like :email";
		List cuList = session.createQuery(namedHQL).setParameter("email", "%k%").list();
		System.out.println("命名参数查询：" + cuList.size());

	}

}
