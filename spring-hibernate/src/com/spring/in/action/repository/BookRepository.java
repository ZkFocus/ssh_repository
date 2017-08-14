package com.spring.in.action.repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.in.action.entity.Book;
import com.spring.in.action.exceptions.BookStockException;
import com.spring.in.action.exceptions.UserAccountException;

@Repository
public class BookRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public int findBookPriceByIsbn(String isbn) {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = :isbn";
		Query query = currentSession().createQuery(hql).setParameter("isbn", isbn);
		Integer price =(Integer) query.uniqueResult();
		System.out.println("书的价格是："+price);
		return price;
	}

	public void updateBookStock(String isbn) {
		// 验证书的库存是否充足.
		String hql2 = "SELECT b.stock FROM Book b WHERE b.isbn = :isbn";
		int stock = (int) currentSession().createQuery(hql2).setParameter("isbn", isbn).uniqueResult();
		System.out.println("书的库存为："+stock);
		if (stock == 0) {
			throw new BookStockException("库存不足!");
		}

		String hql = "UPDATE Book b SET b.stock = b.stock - 1 WHERE b.isbn = :isbn";
		currentSession().createQuery(hql).setParameter("isbn", isbn).executeUpdate();
	}

	public void updateUserAccount(String username, int price) {
		// 验证余额是否足够
		String hql2 = "SELECT a.balance FROM Account a WHERE a.username = :username";
		int balance = (int) currentSession().createQuery(hql2).setParameter("username", username).uniqueResult();
		if (balance < price) {
			throw new UserAccountException("余额不足!");
		}

		String hql = "UPDATE Account a SET a.balance = a.balance - :balance WHERE a.username = :username";
		currentSession().createQuery(hql).setParameter("balance", price).setParameter("username", username).executeUpdate();
	}

	
	
	public List<Book> findAll() {
		return (List<Book>) currentSession().createCriteria(Book.class).list();
	}

	public int test() {
		String hql = "SELECT b.price FROM Book b WHERE b.isbn = ?";
		Query query = currentSession().createQuery(hql).setString(0, "1001");
		return (Integer) query.uniqueResult();
	}
	
	public void testAccount(String username,int price){
		/*String hql2 = "SELECT a.balance FROM Account a WHERE a.username = ?";
		int balance = (int) currentSession().createQuery(hql2).setString(0, username).uniqueResult();
		System.out.println(balance);*/
		String hql = "UPDATE Account a SET a.balance = a.balance - :balance WHERE a.username = :username";
		currentSession().createQuery(hql).setParameter("balance", price).setParameter("username", username).executeUpdate();
	}
}
