package com.albert.bs.dao;

import java.util.Date;
import java.util.List;

import com.albert.bs.model.Comment;

public interface CommentDao extends BaseDao<Comment, String> {
	
	//获得某本书的评论人气
	public int getCountByBook(String bookId);

	//获得某本书的平均评分
	public double getAvgScoreByBook(String bookId);
	
	//获得某本书的评论
	public List<Comment> getBookComments(String bookId, int start, int count);
	
	//获得某人的评论总数
	public int getUserCommentCount(String userId);
	//获得某人的评论(按评论时间倒序)
	public List<Comment> getUserComments(String userId, int start, int count);

	//获得评分<score的评论总数
	public int getLowScoreCommentCount(int score);
	//获得评分<score的评论(按评论时间倒序)
	public List<Comment> getLowScoreComments(int score, int start, int count);
	
	//获得某天的评论总数
	public int getCommentCount(Date commentDate);
	//获得某天的评论(按评论时间倒序)
	public List<Comment> getComments(Date commentDate, int start, int count);
	
}
