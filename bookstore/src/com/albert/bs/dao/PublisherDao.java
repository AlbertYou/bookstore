package com.albert.bs.dao;

import com.albert.bs.model.Publisher;

public interface PublisherDao extends BaseDao<Publisher, String> {

	//查看该出版社是否使用过
	public boolean isUsed(String publisherId);

	//查找是否有该出版社
	public boolean hasPublisher(String publisher);
	
}
