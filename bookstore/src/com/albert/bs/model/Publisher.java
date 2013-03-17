package com.albert.bs.model;

import java.io.Serializable;

/**
 * 出版社
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Publisher implements Serializable {
	private static final long serialVersionUID = 7642116019000624613L;

	private String publisherId;
	private String publisher;
	
	public Publisher() {
		super();
	}
	public Publisher(String publisherId) {
		super();
		this.publisherId = publisherId;
	}
	public Publisher(String publisherId, String publisher) {
		super();
		this.publisherId = publisherId;
		this.publisher = publisher;
	}
	public String getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result
				+ ((publisherId == null) ? 0 : publisherId.hashCode());
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
		Publisher other = (Publisher) obj;
		if (publisher == null) {
			if (other.publisher != null)
				return false;
		} else if (!publisher.equals(other.publisher))
			return false;
		if (publisherId == null) {
			if (other.publisherId != null)
				return false;
		} else if (!publisherId.equals(other.publisherId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Publisher [publisher=" + publisher + "]";
	}
	
}
