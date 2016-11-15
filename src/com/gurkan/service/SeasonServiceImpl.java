package com.gurkan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gurkan.dao.SeasonDAOImpl;
import com.gurkan.domain.Season;

@Service
public class SeasonServiceImpl implements ModelService<Season>{

	@Autowired
	private SeasonDAOImpl seasonDAOImpl;

	@Override
	@Transactional 
	public void insert(Season item) {
		seasonDAOImpl.insert(item);
	}

	@Override
	@Transactional 
	public Season getById(int id) {
		return seasonDAOImpl.getById(id);
	}

	@Override
	@Transactional 
	public List<Season> getAll() {
		return seasonDAOImpl.getAll();
	}

	@Override
	@Transactional 
	public void update(Season item) {
		seasonDAOImpl.update(item);
	}

	@Override
	@Transactional 
	public void delete(int id) {
		seasonDAOImpl.delete(id);
	}

	@Override
	@Transactional 
	public List<Season> getAllWithPagination(int offset, int noOfRecords) {
		return seasonDAOImpl.getAllWithPagination(offset, noOfRecords);
	}
	
}
