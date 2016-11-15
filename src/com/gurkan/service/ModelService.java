package com.gurkan.service;

import java.util.List;


public interface ModelService<T> {
	
	public void insert(T item);
	public T getById(int id);
	public List<T> getAll();
	public void update(T item);
	public void delete(int id);
	public List<T> getAllWithPagination(int offset, int noOfRecords);

}
