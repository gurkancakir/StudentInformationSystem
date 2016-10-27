package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.RoleDAOImpl;
import com.gurkan.domain.Role;

@Service
public class RoleServiceImpl implements ModelService<Role>{

	@Autowired
	private RoleDAOImpl roleDAOImpl;

	@Override
	@Transactional 
	public void insert(Role item) {
		roleDAOImpl.insert(item);		
	}

	@Override
	@Transactional 
	public Role getById(int id) {
		return roleDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Role> getAll() {
		return roleDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Role item) {
		roleDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		roleDAOImpl.delete(id);
	}
}
