package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.PublisherDao;
import com.albert.bs.model.Publisher;
import com.albert.bs.service.PublisherService;

public class PublisherServiceImpl implements PublisherService {

	private PublisherDao dao;

	public void delete(Publisher publisher) {
		dao.delete(publisher);
	}

	public List<Publisher> findAll() {
		return dao.findAll();
	}

	public Publisher findById(String publisherId) {
		return dao.findById(publisherId);
	}

	public void save(Publisher publisher) {
		dao.save(publisher);
	}

	public void update(Publisher publisher) {
		dao.update(publisher);
	}

	public boolean isUsed(String publisherId) {
		return dao.isUsed(publisherId);
	}

	public boolean hasPublisher(String publisher) {
		return dao.hasPublisher(publisher);
	}
	
	
	public PublisherDao getDao() {
		return dao;
	}
	public void setDao(PublisherDao dao) {
		this.dao = dao;
	}

}
