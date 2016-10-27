package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Season;

@Repository
public class SeasonDAOImpl implements ModelDAO<Season>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Season item) {
		Session session = getCurrentSession();
		session.persist(item);
	}

	@Override
	public Season getById(int id) {
		Session session = getCurrentSession();
		Season season = session.get(Season.class, id);
		return season;
	}

	@Override
	public List<Season> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Season> query = session.createQuery("from Season",Season.class);
		return query.getResultList();
	}

	@Override
	public void update(Season item) {
		Session session = getCurrentSession();
		session.update(item);
		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Season s = session.get(Season.class, id);
		System.out.println(s);
		if (s != null){
			session.delete(s);
		}
	}

}
