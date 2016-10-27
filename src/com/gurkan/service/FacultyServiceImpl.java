package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.FacultyDAOImpl;
import com.gurkan.domain.Faculty;

@Service
public class FacultyServiceImpl implements ModelService<Faculty>{

	@Autowired
	private FacultyDAOImpl facultyDAOImpl;

	@Override
	@Transactional 
	public void insert(Faculty item) {
		facultyDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public Faculty getById(int id) {
		return facultyDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Faculty> getAll() {
		return facultyDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Faculty item) {
		facultyDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		facultyDAOImpl.delete(id);
	}
	
	
}
