package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Publisher;

public interface PublisherService {

	public Publisher findById(String publisherId);

	public List<Publisher> findAll();

	public void save(Publisher publisher);
	
	public void update(Publisher publisher);

	public boolean isUsed(String publisherId);
	
	public void delete(Publisher publisher);
	
	public boolean hasPublisher(String publisher);
	
}
