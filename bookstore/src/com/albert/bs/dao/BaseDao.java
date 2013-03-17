package com.albert.bs.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<E, PK extends Serializable> {
	
	public E findById(PK id);

	public List<E> findPaginate(int start, int count);

	public List<E> findAll();
	
	public void save(E entity);
	
	public void update(E entity);
	
	public void delete(E entity);
	
	public int count();
	
}
