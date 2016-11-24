package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Department;
import com.gurkan.domain.Lesson;
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
			//donemdeki derslerle iliskisinin null yapilmasi
			for (Lesson lesson : session.createQuery("from Lesson",Lesson.class).getResultList())
				if (lesson.getSeason() != null && lesson.getSeason().getId() == s.getId())
					lesson.setSeason(null);
			session.delete(s);
		}
	}

	@Override
	public List<Season> getAllWithPagination(int offset, int noOfRecords) {
		Session session = getCurrentSession();
		TypedQuery<Season> query = session.createQuery("from Season",Season.class);
		query.setFirstResult(offset);
		query.setMaxResults(noOfRecords);
		return query.getResultList();
	}

}
