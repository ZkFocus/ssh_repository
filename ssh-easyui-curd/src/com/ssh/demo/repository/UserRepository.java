package com.ssh.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ssh.demo.entity.User;

public class UserRepository {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	public List<User> getAll(){
		String hql="From User";
		return getSession().createQuery(hql).list();
	}
	
	public void saveOrUpdate(User user){
		this.getSession().saveOrUpdate(user);
	}
	public void delete(Integer id){
		String hql="Delete from User where id = ?";
		this.getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}
	public User get(Integer id ){
		return (User) this.getSession().get(User.class, id);
		 
	}
	
	public List<User> find(int page, int rows, Map<String, String> map) {

		List<User> list = new ArrayList<>();// ����list������ʵ����

		String sql = "from User"; // ��������HQL���

		String name = map.get("name");// ���ղ���

		if (name != null && !name.equals(""))// �жϲ���
		{
			sql += "and name =:name ";//
		}

		String tel = map.get("tel");

		if (tel != null && !tel.equals("")) {
			sql += "and tel =:tel ";
		}


		Query qu = sessionFactory.getCurrentSession().createQuery(sql);

		if (name != null && !name.equals("")) {
			qu.setString("name", name);
		}

		if (tel != null && !tel.equals("")) {
			qu.setString("tel", tel);
		}

		list = qu.setMaxResults(rows)// ÿҳ����
				.setFirstResult((page - 1) * rows)// ��ʼҳ��
				.list();

		return list;

	}
	
	public int findTotal(Map<String, String> map) {
		int rtn = 0;// �����������ֵ

		String sql = "select count(1) from Student where 1=1 ";

		String name = map.get("name");// ���ղ���

		if (name != null && !name.equals(""))// �жϲ���
		{
			sql += "and name =:name";//
		}

		String tel = map.get("tel");

		if (tel != null && !tel.equals("")) {
			sql += "and tel =:tel ";
		}

		Query qu = sessionFactory.getCurrentSession().createSQLQuery(sql); // ��ȡQuery����

		if (name != null && !name.equals("")) {
			qu.setString("name", name);
		}

		if (tel != null && !tel.equals("")) {
			qu.setString("tel", tel);
		}

		List<Object> list = qu.list();// ����list������ʵ����

		if (list != null && list.size() > 0)// �жϻ�ȡ�ļ��Ϸǿռ�����
		{
			rtn = Integer.parseInt(list.get(0).toString());// ������rtn��ֵ
		}

		return rtn;// ���ر���ֵ
	}
}
