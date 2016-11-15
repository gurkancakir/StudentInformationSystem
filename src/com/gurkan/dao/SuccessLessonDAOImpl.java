package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.SuccessLesson;

@Repository
public class SuccessLessonDAOImpl implements ModelDAO<SuccessLesson> {


	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(SuccessLesson item) {
		Session session = getCurrentSession();
		session.persist(item);
		
	}

	@Override
	public SuccessLesson getById(int id) {
		Session session = getCurrentSession();
		SuccessLesson successLesson = session.get(SuccessLesson.class, id);
		return successLesson;
	}

	@Override
	public List<SuccessLesson> getAll() {
		Session session = getCurrentSession();
		TypedQuery<SuccessLesson> query = session.createQuery("from SuccessLesson",SuccessLesson.class);
		return query.getResultList();
	}

	@Override
	public void update(SuccessLesson item) {
		Session session = getCurrentSession();
		session.update(item);
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		SuccessLesson s = session.get(SuccessLesson.class, id);
		System.out.println(s);
		if (s != null){
			session.delete(s);
		}
	}

	@Override
	public List<SuccessLesson> getAllWithPagination(int offset, int noOfRecords) {
		Session session = getCurrentSession();
		TypedQuery<SuccessLesson> query = session.createQuery("from SuccessLesson",SuccessLesson.class);
		query.setFirstResult(offset);
		query.setMaxResults(noOfRecords);
		return query.getResultList();
	}
	
}
