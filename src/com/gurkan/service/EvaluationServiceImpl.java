package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.EvaluationDAOImpl;
import com.gurkan.domain.Evaluation;

@Service
public class EvaluationServiceImpl implements ModelService<Evaluation>{

	@Autowired
	private EvaluationDAOImpl evaluationDAOImpl;

	@Override
	public void insert(Evaluation item) {
		evaluationDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public Evaluation getById(int id) {
		return evaluationDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Evaluation> getAll() {
		return evaluationDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Evaluation item) {
		evaluationDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		evaluationDAOImpl.delete(id);
	}
	
}
