package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Lesson;

@Repository
public class LessonDAOImpl implements ModelDAO<Lesson>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Lesson item) {
		Session session = getCurrentSession();
		session.persist(item);
	}

	@Override
	public Lesson getById(int id) {
		Session session = getCurrentSession();
		Lesson lesson = session.get(Lesson.class, id);
		return lesson;
	}

	@Override
	public List<Lesson> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Lesson> query = session.createQuery("from Lesson",Lesson.class);
		return query.getResultList();
	}

	@Override
	public void update(Lesson item) {
		Session session = getCurrentSession();
		session.update(item);		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Lesson l = session.get(Lesson.class, id);
		System.out.println(l);
		if (l != null){
			session.delete(l);
		}
	}

}
