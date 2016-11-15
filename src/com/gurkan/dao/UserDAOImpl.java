package com.gurkan.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.User;

@Repository
public class UserDAOImpl implements ModelDAO<User> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(User user) {
		Session session = getCurrentSession();
		session.persist(user);
		
	}

	@Override
	public User getById(int id) {
		Session session = getCurrentSession();
		User user = session.get(User.class, id);
		return user;
	}

	@Override
	public List<User> getAll() {
		Session session = getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User",User.class);
		return query.getResultList();
	}

	@Override
	public void update(User user) {
		Session session = getCurrentSession();
		session.update(user);
		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		User u = (User) session.get(User.class, new Integer(id));
		System.out.println(u);
		if (u != null) {
			session.delete(u);
		}
		
	}
	
	public int login(String email,String password){
		Session session = getCurrentSession();
		String hql = "Select log.id from User log where log.email=:email and log.password=:password";
		Query query = session.createQuery(hql);
        query.setParameter("email", email);
        query.setParameter("password", password);
        List result = query.list();
		if (result.size() > 0){
			return (int)result.get(0);
		}else{
			return 0;
		}
	}
	
	public User forgot(String email){
		Session session = getCurrentSession();
		String hql = "Select log from User log where log.email=:email";
		Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List result = query.list();
		if (result.size() > 0){
			return (User)result.get(0);
		}else{
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public User findByEmail(String email) {
		Session session = getCurrentSession();
		List<User> users = new ArrayList<User>();

		users = session
			.createQuery("from User usr where usr.email=:email")
			.setParameter("email", email).list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

	@Override
	public List<User> getAllWithPagination(int offset, int noOfRecords) {
		Session session = getCurrentSession();
		TypedQuery<User> query = session.createQuery("from User",User.class);
		query.setFirstResult(offset);
		query.setMaxResults(noOfRecords);
		return query.getResultList();
	}
	
}
