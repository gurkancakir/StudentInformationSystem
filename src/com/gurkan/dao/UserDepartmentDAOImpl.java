package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.User;
import com.gurkan.domain.UserDepartment;

@Repository
public class UserDepartmentDAOImpl implements ModelDAO<UserDepartment>{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(UserDepartment item) {
		Session session = getCurrentSession();
		session.persist(item);		
	}

	@Override
	public UserDepartment getById(int id) {
		Session session = getCurrentSession();
		UserDepartment userDepartment = session.get(UserDepartment.class, id);
		return userDepartment;
	}

	@Override
	public List<UserDepartment> getAll() {
		Session session = getCurrentSession();
		TypedQuery<UserDepartment> query = session.createQuery("from UserDepartment",UserDepartment.class);
		return query.getResultList();
	}

	@Override
	public void update(UserDepartment item) {
		Session session = getCurrentSession();
		session.update(item);		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		UserDepartment u = session.get(UserDepartment.class, id);
		System.out.println(u);
		if (u != null){
			session.delete(u);
		}
	}
	

}
