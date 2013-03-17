package com.albert.bs.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 图书收藏
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Collect implements Serializable {
	private static final long serialVersionUID = -8475389816706694966L;
	
	private String collectId;
	private Book book; //图书
	private User user; //用户
	private String title; //收藏标题
	private Date collectDate; //收藏时间
	
	public Collect() {
		
	}
	public Collect(String collectId) {
		this.collectId = collectId;
	}
	public Collect(String collectId, Book book, User user, String title,
			Date collectDate) {
		super();
		this.collectId = collectId;
		this.book = book;
		this.user = user;
		this.title = title;
		this.collectDate = collectDate;
	}
	public String getCollectId() {
		return collectId;
	}
	public void setCollectId(String collectId) {
		this.collectId = collectId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCollectDate() {
		return collectDate;
	}
	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result
				+ ((collectDate == null) ? 0 : collectDate.hashCode());
		result = prime * result
				+ ((collectId == null) ? 0 : collectId.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Collect other = (Collect) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (collectDate == null) {
			if (other.collectDate != null)
				return false;
		} else if (!collectDate.equals(other.collectDate))
			return false;
		if (collectId == null) {
			if (other.collectId != null)
				return false;
		} else if (!collectId.equals(other.collectId))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Collect [user=" + user + ", book=" + book + "]";
	}
	
}
