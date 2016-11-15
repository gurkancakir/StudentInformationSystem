package com.gurkan.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gurkan.domain.Department;

@Repository
public class DepartmentDAOImpl implements ModelDAO<Department>{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void insert(Department item) {
		Session session = getCurrentSession();
		session.persist(item);
		
	}

	@Override
	public Department getById(int id) {
		Session session = getCurrentSession();
		Department department = session.get(Department.class, id);
		return department;
	}

	@Override
	public List<Department> getAll() {
		Session session = getCurrentSession();
		TypedQuery<Department> query = session.createQuery("from Department",Department.class);
		return query.getResultList();
	}

	@Override
	public void update(Department item) {
		Session session = getCurrentSession();
		session.update(item);
		
	}

	@Override
	public void delete(int id) {
		Session session = getCurrentSession();
		Department d = (Department) session.get(Department.class, new Integer(id));
		System.out.println(d);
		if (d != null) {
			session.delete(d);
		}
		
	}

	@Override
	public List<Department> getAllWithPagination(int offset, int noOfRecords) {
		Session session = getCurrentSession();
		TypedQuery<Department> query = session.createQuery("from Department",Department.class);
		query.setFirstResult(offset);
		query.setMaxResults(noOfRecords);
		return query.getResultList();
	}
	
}
