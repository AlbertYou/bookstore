package com.albert.bs.serviceimpl;

import java.io.Serializable;
import java.util.List;

import com.albert.bs.dao.BaseDao;
import com.albert.bs.service.BaseService;

public class BaseServiceImpl<E, PK extends Serializable> implements BaseService<E, PK>{

	private BaseDao<E, Serializable> dao;

	public E findById(PK id) {
		return dao.findById(id);
	}

	public void delete(E entity) {
		dao.delete(entity);
	}

	public List<E> findPaginate(int start, int count) {
		return dao.findPaginate(start, count);
	}
	
	public List<E> findAll() {
		return dao.findAll();
	}

	public void save(E entity) {
		dao.save(entity);
	}

	public void update(E entity) {
		dao.update(entity);
	} 

	public BaseDao<E, Serializable> getDao() {
		return dao;
	}
	public void setDao(BaseDao<E, Serializable> dao) {
		this.dao = dao;
	}

}
