package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.UserLesson;

@Repository
public class UserLessonDAOImpl implements ModelDAO<UserLesson>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(UserLesson item) {
		Session session = getCurrentSession();
		session.persist(item);
	}

	@Override
	public UserLesson getById(int id) {
		Session session = getCurrentSession();
		UserLesson userLesson = session.get(UserLesson.class, id);
		return userLesson;
	}

	@Override
	public List<UserLesson> getAll() {
		Session session = getCurrentSession();
		TypedQuery<UserLesson> query = session.createQuery("from UserLesson",UserLesson.class);
		return query.getResultList();
	}

	@Override
	public void update(UserLesson item) {
		Session session = getCurrentSession();
		session.update(item);
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		UserLesson u = session.get(UserLesson.class, id);
		System.out.println(u);
		if (u != null){
			session.delete(u);
		}
	}
	
}
