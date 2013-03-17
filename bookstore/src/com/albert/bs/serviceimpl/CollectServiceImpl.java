package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.CollectDao;
import com.albert.bs.model.Collect;
import com.albert.bs.service.CollectService;

public class CollectServiceImpl implements CollectService {

	private CollectDao dao;
	
	public boolean isCollected(String userId, String bookId) {
		return dao.isCollected(userId, bookId);
	}
	public int getCountByBook(String bookId) {
		return dao.getCountByBook(bookId);
	}
	public int getCollectCount(String userId) {
		return dao.getCollectCount(userId);
	}
	public void modifyTitle(String collectId, String title) {
		dao.modifyTitle(collectId, title);
	}
	public void save(Collect collect) {
		dao.save(collect);
	}
	public void delete(Collect collect) {
		dao.delete(collect);
	}
	public void deleteCollects(String userId) {
		dao.deleteCollects(userId);
	}
	public List<Collect> findPaginate(String userId, int start, int count) {
		return dao.findPaginate(userId, start, count);
	}
	
	
	public CollectDao getDao() {
		return dao;
	}
	public void setDao(CollectDao dao) {
		this.dao = dao;
	}

}
