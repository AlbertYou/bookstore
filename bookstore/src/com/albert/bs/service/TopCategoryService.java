package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.TopCategory;

public interface TopCategoryService {

	public TopCategory findById(String categoryId);

	public List<TopCategory> findAll();
	
	public void save(TopCategory category);

	public void update(TopCategory category);
	
	public void deleteTopCategory(TopCategory category);
	
	public int getChildrenCount(String categoryId);
	
	public boolean hasCategory(String category);
	
}
