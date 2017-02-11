package com.librarySystem;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import com.librarySystem.User;
import com.librarySystem.Book;

@Service("bookBo")
public class SystemInterfaceImplementation extends CustomHibernateDaoSupport implements SystemInterface{

	public void newBook(Book b) {
		getHibernateTemplate().save(b);
	}

	public void deleteBook(Book b) {
		getHibernateTemplate().delete(b);
	}

	public List<Book> viewBooks() {		
		List<Book> l=getHibernateTemplate().find("from Book");		
		return l;
	}

	public void issueBook(RentBooks r) {
		// TODO Auto-generated method stub
		
	}

	public void returnBook(RentBooks r) {
		// TODO Auto-generated method stub
		
	}

	public void newUser(User b) {
		getHibernateTemplate().save(b);
	}

	public void removeUser(User b) {
		getHibernateTemplate().delete(b);
	}

	public boolean loginUser(User b) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx= session.beginTransaction();
		Query query = session .createQuery("from User where name= :name and pass= :pass"); 
		query.setParameter("name", b.getName());
		query.setParameter("pass", b.getPass());
		List<User> list = (List<User>) query.list();
		tx.commit(); session.close(); factory.close();
		if(list.size()>0)
			return true;
		return false;
		
	}

	public boolean loginAdmin(Admin b) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session .createQuery("from Admin where id= :id and pass= :pass"); 
		query.setParameter("id", b.getId());
		query.setParameter("pass", b.getPass());
		List<User> list = (List<User>) query.list();
		tx.commit(); session.close(); factory.close();
		if(list.size()>0)
			return true;
		return false;
	}

	public void updateBookCategory(Book b, String category) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session .createQuery("update Book set category= :cat where id= :id"); 
		query.setParameter("cat", category);
		query.setParameter("id", b.getId());
		query.executeUpdate();
		tx.commit(); session.close(); factory.close();
		
	}

	public List<Book> viewBooksByCategory(String cat) {
		List<Book> l=getHibernateTemplate().find("from Book where category='"+cat+"'");				
		return l;
	}

	public List<Book> viewBooksByName(String name) {
		List<Book> l=getHibernateTemplate().find("from Book where name='"+name+"'");				
		return l;
	}

	public List<Book> viewBooksByAuthor(String author) {
		List<Book> l=getHibernateTemplate().find("from Book where author='"+author+"'");				
		return l;		
	}

	public List<User> viewUsers() {
		List<User> l=getHibernateTemplate().find("from User");				
		return l;
	}

	public void UpdateQuantity(Book b, int n) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session .createQuery("update Book set qty= :n where id= :id"); 
		query.setParameter("n", n);
		query.setParameter("id", b.getId());
		query.executeUpdate();
		tx.commit(); session.close(); factory.close();
	}

	public boolean CheckBookAvailability(Book b) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session .createQuery("from Book where id= :id"); 
		query.setParameter("id", b.getId());
		List<Book> list = (List<Book>) query.list();
		int avail=list.get(0).getAvailable(); 
		tx.commit(); session.close(); factory.close();
		if(avail==1)
			return true;
		return false;
	}

	public void ChangeAvailability(Book b, int n) {
		SessionFactory factory=getHibernateTemplate().getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session .createQuery("update Book set availability= :n where id= :id"); 
		query.setParameter("n", n);
		query.setParameter("id", b.getId());
		query.executeUpdate();
		tx.commit(); session.close(); factory.close();
	}

	
}
