package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.LessonDAOImpl;
import com.gurkan.domain.Lesson;

@Service
public class LessonServiceImpl implements ModelService<Lesson>{

	@Autowired
	private LessonDAOImpl lessonDAOImpl;

	@Override
	@Transactional 
	public void insert(Lesson item) {
		lessonDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public Lesson getById(int id) {
		return lessonDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Lesson> getAll() {
		return lessonDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Lesson item) {
		lessonDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		lessonDAOImpl.delete(id);
	}
	
}
