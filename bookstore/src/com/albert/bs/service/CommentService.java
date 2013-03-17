package com.albert.bs.service;

import java.util.Date;
import java.util.List;

import com.albert.bs.model.Comment;

public interface CommentService {

	public void save(Comment comment);
	
	public int getCountByBook(String bookId);

	public double getAvgScoreByBook(String bookId);
	
	List<Comment> getBookComments(String bookId, int start, int count);
	
	public int getUserCommentCount(String userId);
	public List<Comment> getUserComments(String userId, int start, int count);

	public int getLowScoreCommentCount(int score);
	public List<Comment> getLowScoreComments(int score, int start, int count);
	
	public int getCommentCount(Date commentDate);
	public List<Comment> getComments(Date commentDate, int start, int count);
	
	
	
}
