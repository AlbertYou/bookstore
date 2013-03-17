package com.albert.bs.daoimpl;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.TopCategoryDao;
import com.albert.bs.model.LowCategory;
import com.albert.bs.model.TopCategory;

public class TopCategoryDaoImpl extends BaseDaoImpl<TopCategory, String> implements TopCategoryDao {

	public void update(TopCategory category) {
		TopCategory c = (TopCategory) getHibernateTemplate().load(TopCategory.class, category.getCategoryId()); 
		c.setName(category.getName());
	}

	public int getChildrenCount(String categoryId) {
		Integer i = (Integer) getSession(false).createCriteria(LowCategory.class).setProjection(Projections.rowCount()).add(Restrictions.eq("parent.categoryId", categoryId)).uniqueResult();
		return i;
	}
	
	public void delete(TopCategory category) {
		TopCategory c = (TopCategory) getHibernateTemplate().load(TopCategory.class, category.getCategoryId()); 
		getHibernateTemplate().delete(c);
	}

	public boolean hasCategory(String category) {
		int size = (Integer) getSession(false).createCriteria(TopCategory.class).setProjection(Projections.rowCount()).add(Restrictions.eq("name", category)).uniqueResult();
		if(size > 0) {
			return true;
		}
		return false;
	}
	
}
