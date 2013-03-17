package com.albert.bs.serviceimpl;

import java.util.Date;
import java.util.List;

import com.albert.bs.dao.CommentDao;
import com.albert.bs.model.Comment;
import com.albert.bs.service.CommentService;

public class CommentServiceImpl implements CommentService {

	private CommentDao dao;
	
	public void save(Comment comment) {
		dao.save(comment);
	}
	
	public double getAvgScoreByBook(String bookId) {
		return dao.getAvgScoreByBook(bookId);
	}

	public int getCountByBook(String bookId) {
		return dao.getCountByBook(bookId);
	}
	
	public List<Comment> getBookComments(String bookId, int start, int count) {
		return dao.getBookComments(bookId, start, count);
	}

	public int getUserCommentCount(String userId) {
		return dao.getUserCommentCount(userId);
	}
	public List<Comment> getUserComments(String userId, int start, int count) {
		return dao.getUserComments(userId, start, count);
	}
	
	public int getLowScoreCommentCount(int score) {
		return dao.getLowScoreCommentCount(score);
	}
	public List<Comment> getLowScoreComments(int score, int start, int count) {
		return dao.getLowScoreComments(score, start, count);
	}
	
	public int getCommentCount(Date commentDate) {
		return dao.getCommentCount(commentDate);
	}
	public List<Comment> getComments(Date commentDate, int start, int count) {
		return dao.getComments(commentDate, start, count);
	}
	
	public CommentDao getDao() {
		return dao;
	}
	public void setDao(CommentDao dao) {
		this.dao = dao;
	}
	
}
