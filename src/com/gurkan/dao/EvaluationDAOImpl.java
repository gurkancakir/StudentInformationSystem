package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Evaluation;

@Repository
public class EvaluationDAOImpl implements ModelDAO<Evaluation>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insert(Evaluation item) {
		Session session = getCurrentSession();
		session.persist(item);
	}

	@Override
	public Evaluation getById(int id) {
		Session session = getCurrentSession();
		Evaluation evaluation = session.get(Evaluation.class, id);
		return evaluation;
	}

	@Override
	public List<Evaluation> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Evaluation> query = session.createQuery("from Evaluation",Evaluation.class);
		return query.getResultList();
	}

	@Override
	public void update(Evaluation item) {
		Session session = getCurrentSession();
		session.update(item);
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Evaluation e = session.get(Evaluation.class, new Integer(id));
		System.out.println(e);
		if (e != null){
			session.delete(e);
		}
	}

}
