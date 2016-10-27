package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Faculty;

@Repository
public class FacultyDAOImpl implements ModelDAO<Faculty>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Faculty item) {
		Session session = getCurrentSession();
		session.persist(item);
		
	}

	@Override
	public Faculty getById(int id) {
		Session session = getCurrentSession();
		Faculty faculty = session.get(Faculty.class, id);
		return faculty;
	}

	@Override
	public List<Faculty> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Faculty> query = session.createQuery("from Faculty",Faculty.class);
		return query.getResultList();
	}

	@Override
	public void update(Faculty item) {
		Session session = getCurrentSession();
		session.update(item);
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Faculty f = session.get(Faculty.class, id);
		System.out.println(f);
		if (f != null){
			session.delete(f);
		}
	}
}
