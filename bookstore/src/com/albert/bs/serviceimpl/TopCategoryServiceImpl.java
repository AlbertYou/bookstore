package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.TopCategoryDao;
import com.albert.bs.model.TopCategory;
import com.albert.bs.service.TopCategoryService;

public class TopCategoryServiceImpl implements TopCategoryService {

	private TopCategoryDao dao;

	public TopCategory findById(String categoryId) {
		return dao.findById(categoryId);
	}
	public List<TopCategory> findAll() {
		return dao.findAll();
	}
	public void save(TopCategory category) {
		dao.save(category);
	}
	public void update(TopCategory category) {
		dao.update(category);
	}
	public void deleteTopCategory(TopCategory category) {
		dao.delete(category);
	}
	public int getChildrenCount(String categoryId) {
		return dao.getChildrenCount(categoryId);
	}
	public boolean hasCategory(String category) {
		return dao.hasCategory(category);
	}
	
	public TopCategoryDao getDao() {
		return dao;
	}
	public void setDao(TopCategoryDao dao) {
		this.dao = dao;
	}
	
}
