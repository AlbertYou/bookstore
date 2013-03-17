package com.albert.bs.daoimpl;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.PublisherDao;
import com.albert.bs.model.Book;
import com.albert.bs.model.Publisher;

public class PublisherDaoImpl extends BaseDaoImpl<Publisher, String> implements PublisherDao {

	public void update(Publisher publisher) {
		Publisher p = (Publisher) getHibernateTemplate().load(Publisher.class, publisher.getPublisherId());
		p.setPublisher(publisher.getPublisher());
		getHibernateTemplate().update(p);
	}
	
	public boolean isUsed(String publisherId) {
		int size = (Integer) getSession(false).createCriteria(Book.class).setProjection(Projections.rowCount()).createCriteria("publisher").add(Restrictions.eq("publisherId", publisherId)).uniqueResult();
		if(size > 0) {
			return true;
		}
		return false;
	}
	
	public boolean hasPublisher(String publisher) {
		int size = (Integer) getSession(false).createCriteria(Publisher.class).setProjection(Projections.rowCount()).add(Restrictions.eq("publisher", publisher)).uniqueResult();
		if(size > 0) {
			return true;
		}
		return false;
	}
	
}
