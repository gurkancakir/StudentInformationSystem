package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.UserDAOImpl;
import com.gurkan.domain.User;

@Service
public class UserServiceImpl implements ModelService<User>{

	@Autowired
	private UserDAOImpl userDAOImpl;
	
	@Override
	@Transactional 
	public void insert(User item) {
		userDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public User getById(int id) {
		return userDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<User> getAll() {
		return userDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(User item) {
		userDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		userDAOImpl.delete(id);
	}

}
