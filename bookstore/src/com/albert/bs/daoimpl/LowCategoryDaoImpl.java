package com.albert.bs.daoimpl;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.LowCategoryDao;
import com.albert.bs.model.Book;
import com.albert.bs.model.LowCategory;

public class LowCategoryDaoImpl extends BaseDaoImpl<LowCategory, String> implements LowCategoryDao {

	public void update(LowCategory category) {
		LowCategory c = (LowCategory) getHibernateTemplate().load(LowCategory.class, category.getCategoryId());
		c.setName(category.getName());
	}

	public int getBooksCount(String categoryId) {
		return (Integer) getSession(false).createCriteria(Book.class).setProjection(Projections.rowCount()).add(Restrictions.eq("category.categoryId", categoryId)).uniqueResult();
	}
	
	public void delete(LowCategory category) {
		LowCategory c = (LowCategory) getHibernateTemplate().load(LowCategory.class, category.getCategoryId());
		getHibernateTemplate().delete(c);
	}
	
}
