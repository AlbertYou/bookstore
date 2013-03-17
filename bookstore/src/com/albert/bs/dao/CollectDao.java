package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.Collect;

public interface CollectDao extends BaseDao<Collect, String> {
	
	//判断是否收藏过某书
	public boolean isCollected(String userId, String bookId);
	
	//获得某本书的收藏人气
	public int getCountByBook(String bookId);

	//获得某用户的收藏总数
	public int getCollectCount(String userId);
	
	//清空某用户的所有收藏
	public void deleteCollects(String userId);
	
	//分页获取某用户的所有收藏
	public List<Collect> findPaginate(String userId, int start, int count);
	
	//修改收藏标签
	public void modifyTitle(String collectId, String title);
	
}
