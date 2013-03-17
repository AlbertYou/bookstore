package com.albert.bs.dao;

import com.albert.bs.model.TopCategory;

public interface TopCategoryDao extends BaseDao<TopCategory, String> {

	//获得子类别的个数
	public int getChildrenCount(String categoryId);

	//是否存在该图书分类
	public boolean hasCategory(String category);
	
}
