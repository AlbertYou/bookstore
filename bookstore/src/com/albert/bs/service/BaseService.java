package com.albert.bs.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, PK extends Serializable> {
	
	public E findById(PK id);

	public List<E> findPaginate(int start, int count);

	public List<E> findAll();
	
	public void save(E entity);
	
	public void update(E entity);
	
	public void delete(E entity);
	
}
