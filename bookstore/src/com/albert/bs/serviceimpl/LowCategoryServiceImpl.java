package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.LowCategoryDao;
import com.albert.bs.model.LowCategory;
import com.albert.bs.service.LowCategoryService;

public class LowCategoryServiceImpl implements LowCategoryService {

	private LowCategoryDao dao;

	public void deleteLowCategory(LowCategory category) {
		dao.delete(category);
	}
	public LowCategory findById(String categoryId) {
		return dao.findById(categoryId);
	}
	public List<LowCategory> findAll() {
		return dao.findAll();
	}
	public void save(LowCategory category) {
		dao.save(category);
	}
	public void update(LowCategory category) {
		dao.update(category);
	}
	public int getBooksCount(String categoryId) {
		return dao.getBooksCount(categoryId);
	}
	
	public LowCategoryDao getDao() {
		return dao;
	}
	public void setDao(LowCategoryDao dao) {
		this.dao = dao;
	}
	
}
