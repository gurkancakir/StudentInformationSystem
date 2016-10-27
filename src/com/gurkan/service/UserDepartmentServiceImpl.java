package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gurkan.dao.UserDepartmentDAOImpl;
import com.gurkan.domain.UserDepartment;

@Service
public class UserDepartmentServiceImpl implements ModelService<UserDepartment> {

	@Autowired
	private UserDepartmentDAOImpl userDepartmentDAOImpl;

	@Override
	public void insert(UserDepartment item) {
		userDepartmentDAOImpl.insert(item);
	}

	@Override
	public UserDepartment getById(int id) {
		return userDepartmentDAOImpl.getById(id);
	}

	@Override
	public List<UserDepartment> getAll() {
		return userDepartmentDAOImpl.getAll();
	}

	@Override
	public void update(UserDepartment item) {
		userDepartmentDAOImpl.update(item);
	}

	@Override
	public void delete(int id) {
		userDepartmentDAOImpl.delete(id);
	}
	
	
}
