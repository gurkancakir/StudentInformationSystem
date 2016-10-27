package com.gurkan.dao;

import java.util.List;


public interface ModelDAO<T> {
	
	public void insert(T item);
	public T getById(int id);
	public List<T> getAll();
	public void update(T item);
	public void delete(int id);

}
