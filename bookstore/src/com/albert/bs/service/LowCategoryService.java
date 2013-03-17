package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.LowCategory;

public interface LowCategoryService {

	public LowCategory findById(String categoryId);

	public List<LowCategory> findAll();
	
	public void save(LowCategory category);

	public void update(LowCategory category);
	
	public void deleteLowCategory(LowCategory category);
	
	public int getBooksCount(String categoryId);
	
}
