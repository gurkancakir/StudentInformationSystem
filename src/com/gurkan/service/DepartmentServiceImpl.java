package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.DepartmentDAOImpl;
import com.gurkan.domain.Department;

@Service
public class DepartmentServiceImpl implements ModelService<Department>{

	@Autowired
	private DepartmentDAOImpl departmentDAOImpl;
	
	@Override
	@Transactional 
	public void insert(Department item) {
		departmentDAOImpl.insert(item);		
	}

	@Override
	@Transactional 
	public Department getById(int id) {
		return departmentDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Department> getAll() {
		return departmentDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Department item) {
		departmentDAOImpl.update(item);		
	}

	@Override
	@Transactional 
	public void delete(int id) {
		departmentDAOImpl.delete(id);		
	}

}
