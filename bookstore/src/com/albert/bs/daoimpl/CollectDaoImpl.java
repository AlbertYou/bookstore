package com.albert.bs.daoimpl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.CollectDao;
import com.albert.bs.model.Collect;

public class CollectDaoImpl extends BaseDaoImpl<Collect, String> implements CollectDao {

	public boolean isCollected(String userId, String bookId) {
		Collect collect = (Collect) getSession(false).createCriteria(Collect.class).add(Restrictions.eq("user.userId", userId)).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
		if(collect == null) {
			return false;
		}
		return true;
	}
	
	public int getCountByBook(String bookId) {
		return (Integer) getSession(false).createCriteria(Collect.class).setProjection(Projections.rowCount()).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
	}

	public int getCollectCount(String userId) {
		return (Integer) getSession(false).createCriteria(Collect.class).setProjection(Projections.rowCount()).add(Restrictions.eq("user.userId", userId)).uniqueResult();
	}
	
	public void modifyTitle(String collectId, String title) {
		Collect collect  = (Collect) getHibernateTemplate().load(Collect.class,collectId);
		collect.setTitle(title);
		getHibernateTemplate().update(collect);
	}
	
	public void delete(Collect collect) {
		collect = (Collect) getHibernateTemplate().load(Collect.class, collect.getCollectId());
		getHibernateTemplate().delete(collect);
	}
	
	@SuppressWarnings("unchecked")
	public void deleteCollects(String userId) {
		List<Collect> collects = getSession(false).createCriteria(Collect.class).add(Restrictions.eq("user.userId", userId)).list();
		for (Collect collect : collects) {
			getHibernateTemplate().delete(collect);
		}
	}

	@SuppressWarnings("unchecked")
	public List<Collect> findPaginate(String userId, int start, int count) {
		List<Collect> collects = getSession(false).createCriteria(Collect.class).add(Restrictions.eq("user.userId", userId)).setFirstResult(start).setMaxResults(count).list();
		return collects;
	}


}
