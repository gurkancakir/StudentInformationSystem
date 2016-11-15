package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.UserDepartmentDAOImpl;
import com.gurkan.domain.UserDepartment;

@Service
public class UserDepartmentServiceImpl implements ModelService<UserDepartment> {

	@Autowired
	private UserDepartmentDAOImpl userDepartmentDAOImpl;

	@Override
	@Transactional
	public void insert(UserDepartment item) {
		userDepartmentDAOImpl.insert(item);
	}

	@Override
	@Transactional
	public UserDepartment getById(int id) {
		return userDepartmentDAOImpl.getById(id);
	}

	@Override
	@Transactional
	public List<UserDepartment> getAll() {
		return userDepartmentDAOImpl.getAll();
	}

	@Override
	@Transactional
	public void update(UserDepartment item) {
		userDepartmentDAOImpl.update(item);
	}

	@Override
	@Transactional
	public void delete(int id) {
		userDepartmentDAOImpl.delete(id);
	}

	@Override
	@Transactional
	public List<UserDepartment> getAllWithPagination(int offset, int noOfRecords) {
		return userDepartmentDAOImpl.getAllWithPagination(offset, noOfRecords);
	}
	
	
}
