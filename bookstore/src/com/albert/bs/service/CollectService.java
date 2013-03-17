package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Collect;

public interface CollectService {

	public boolean isCollected(String userId, String bookId);
	
	public int getCountByBook(String bookId);
	
	public int getCollectCount(String userId);
	
	public void modifyTitle(String collectId, String title);
	
	public void save(Collect collect);
	
	public void delete(Collect collect);
	
	public void deleteCollects(String userId);
	
	public List<Collect> findPaginate(String userId, int start, int count);
	
}
