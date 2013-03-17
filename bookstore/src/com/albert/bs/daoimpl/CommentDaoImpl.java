package com.albert.bs.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.CommentDao;
import com.albert.bs.model.Comment;

public class CommentDaoImpl extends BaseDaoImpl<Comment, String> implements CommentDao {

	public int getCountByBook(String bookId) {
		return (Integer) getSession(false).createCriteria(Comment.class).setProjection(Projections.rowCount()).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
	}

	public double getAvgScoreByBook(String bookId) {
		Double s =  (Double) getSession(false).createCriteria(Comment.class).setProjection(Projections.avg("score")).add(Restrictions.eq("book.bookId", bookId)).uniqueResult();
		if(s == null) {
			s = 0.0;
		}
		return s;
	}

	@SuppressWarnings("unchecked")
	public List<Comment> getBookComments(String bookId, int start, int count) {
		return getSession(false).createCriteria(Comment.class).add(Restrictions.eq("book.bookId", bookId)).setFirstResult(start).setMaxResults(count).list();
	}

	public int getUserCommentCount(String userId) {
		return (Integer) getSession(false).createCriteria(Comment.class).setProjection(Projections.rowCount()).add(Restrictions.eq("user.userId", userId)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Comment> getUserComments(String userId, int start, int count) {
		return getSession(false).createCriteria(Comment.class).add(Restrictions.eq("user.userId", userId)).addOrder(Order.desc("commentDate")).setFirstResult(start).setMaxResults(count).list();
	}

	public int getLowScoreCommentCount(int score) {
		return (Integer) getSession(false).createCriteria(Comment.class).setProjection(Projections.rowCount()).add(Restrictions.lt("score", score)).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<Comment> getLowScoreComments(int score, int start, int count) {
		return getSession(false).createCriteria(Comment.class).add(Restrictions.lt("score", score)).addOrder(Order.desc("commentDate")).setFirstResult(start).setMaxResults(count).list();
	}

	public int getCommentCount(Date commentDate) {
		String hql = "select count(commentId) from Comment where date(:commentDate) = date_format(commentDate,'%Y%m%d')";
		return ((Long) getSession(false).createQuery(hql).setDate("commentDate", commentDate).uniqueResult()).intValue();
	}
	@SuppressWarnings("unchecked")
	public List<Comment> getComments(Date commentDate, int start, int count) {
		String hql = "from Comment where date(:commentDate) = date_format(commentDate,'%Y%m%d') order by commentDate desc";
		return getSession(false).createQuery(hql).setDate("commentDate", commentDate).setFirstResult(start).setMaxResults(count).list();
	}
	
	
}
