package com.albert.bs.dao;

import com.albert.bs.model.LowCategory;

public interface LowCategoryDao extends BaseDao<LowCategory, String> {
	
	//获得该类别图书的个数
	public int getBooksCount(String categoryId);

}
