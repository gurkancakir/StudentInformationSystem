package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.UserLessonDAOImpl;
import com.gurkan.domain.UserLesson;

@Service
public class UserLessonServiceImpl implements ModelService<UserLesson>{

	@Autowired
	private UserLessonDAOImpl userLessonDAOImpl;
	
	@Override
	@Transactional 
	public void insert(UserLesson item) {
		userLessonDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public UserLesson getById(int id) {
		return userLessonDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<UserLesson> getAll() {
		return userLessonDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(UserLesson item) {
		userLessonDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		userLessonDAOImpl.delete(id);
	}

	@Override
	public List<UserLesson> getAllWithPagination(int offset, int noOfRecords) {
		return userLessonDAOImpl.getAllWithPagination(offset, noOfRecords);
	}

}
