package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.SuccessLessonDAOImpl;
import com.gurkan.domain.SuccessLesson;

@Service
public class SuccessLessonServiceImpl implements ModelService<SuccessLesson>{

	@Autowired
	private SuccessLessonDAOImpl successLessonDAOImpl;

	@Override
	@Transactional 
	public void insert(SuccessLesson item) {
		successLessonDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public SuccessLesson getById(int id) {
		return successLessonDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<SuccessLesson> getAll() {
		return successLessonDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(SuccessLesson item) {
		successLessonDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		successLessonDAOImpl.delete(id);
	}

	@Override
	@Transactional
	public List<SuccessLesson> getAllWithPagination(int offset, int noOfRecords) {
		return successLessonDAOImpl.getAllWithPagination(offset, noOfRecords);
	}
	
}
