package com.albert.bs.daoimpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.albert.bs.dao.BaseDao;

public abstract class BaseDaoImpl<E, PK extends Serializable> extends HibernateDaoSupport implements BaseDao<E, PK>{

	private Class<E> clazz;
	
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public E findById(PK id) {
		return (E) getHibernateTemplate().get(clazz, id);
	}

	public void delete(E entity) {
		getHibernateTemplate().delete(entity);
	}

	@SuppressWarnings("unchecked")
	public List<E> findPaginate(int start, int count) {
		return getSession(false).createCriteria(clazz).setFirstResult(start).setMaxResults(count).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		return getSession(false).createCriteria(clazz).list();
	}

	public void save(E entity) {
		getHibernateTemplate().save(entity);
	}

	public void update(E entity) {
		getHibernateTemplate().update(entity);
	}
	
	public int count() {
		return (Integer) getSession(false).createCriteria(clazz).setProjection(Projections.rowCount()).uniqueResult();
	}
}
