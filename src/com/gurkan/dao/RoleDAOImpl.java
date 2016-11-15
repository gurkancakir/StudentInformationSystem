package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Role;

@Repository
public class RoleDAOImpl implements ModelDAO<Role> {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public void insert(Role role) {
		Session session = getCurrentSession();
		session.persist(role);
		
	}

	@Override
	public Role getById(int id) {
		Session session = getCurrentSession();
		Role role = session.get(Role.class, id);
		return role;
	}

	@Override
	public List<Role> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Role> query = session.createQuery("from Role",Role.class);
		return query.getResultList();
	}

	@Override
	public void update(Role role) {
		Session session = getCurrentSession();
		session.update(role);
		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Role r = (Role) session.get(Role.class, new Integer(id));
		System.out.println(r);
		if (r != null) {
			session.delete(r);
		}
		
	}

	@Override
	public List<Role> getAllWithPagination(int offset, int noOfRecords) {
		Session session = getCurrentSession();
		TypedQuery<Role> query = session.createQuery("from Role",Role.class);
		query.setFirstResult(offset);
		query.setMaxResults(noOfRecords);
		return query.getResultList();
	}

}
