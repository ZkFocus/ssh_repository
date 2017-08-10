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
	 * 原生SQl使用方式
	 * 通过调用session.createNativeQuery
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
		//第一条记录从0开始 第一页 0-3 第二页4-7 第三页8-11
		List<Order> order=criteria.setFirstResult((pageNo-1)*pageSize).setMaxResults(pageSize).list();
		System.out.println(order);
	}
	/**
	 * 排序用法 
	 * 通过org.hibernate.criterion.Order 提供的asc方法 desc方法来设置根据哪个字段来排序
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
	 * Criteria用法一 
	 *  select
        this_.ID as ID1_1_0_,
        this_.ORDERNO as ORDERNO2_1_0_,
        this_.PRICE as PRICE3_1_0_,
        this_.C_ID as C_ID4_1_0_ 
    from
        ORDER_ this_ 
    where
        this_.ORDERNO=?
	 * 条件查询  = 查询方式      
	 * =在代码中表示为 Restrictions.eq 
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
	 * 自我探索
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
	 * 投影查询 获取部分属性 直接以get方式获取
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
		//默认返回的是object数组 访问数据不方便 
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
	 * 分页查询
	 */
	@Test
	public void testPage(){
		String hql="From Order";
		Query query=session.createQuery(hql);
		int pageNo=3;	//第四页
		int pageSize=4; //每一页的总条数
		//第一条记录从0开始 第一页 0-3 第二页4-7 第三页8-11 第四页第一条记录号为12
		//pageNo*pageSize 最后一条记录 减去  -pageSize 每一页的条数 
		//setFirstResult 某一页的第一条记录 记录号从0算起
		//setMaxResults  每一页的记录数
		List<Order> orders=query.setFirstResult((pageNo*pageSize-pageSize)).setMaxResults(pageSize).list();
		System.out.println(orders);
	}
	
	/**
	 * hql也支持函数的使用
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
	 * HQL支持自定义类型的参数设置
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
		//创建query对象 占位符的查询
		String hql="From Customer c where c.email like ?";
		Query query=session.createQuery(hql);
		//绑定参数 
		query.setParameter(0, "%a%");
		//执行查询
		List<Customer> customers= query.list();
		System.out.println(customers.size());
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		//命名参数的查询 
		String namedHL="From Customer c where c.email like :email";
		List<Customer> cList=session.createQuery(namedHL).setParameter("email", "%g%").list();
		System.out.println("占位符："+cList.size());
	}
}
