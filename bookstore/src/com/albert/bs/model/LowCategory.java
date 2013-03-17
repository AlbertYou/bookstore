package com.albert.bs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 二级图书类别
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class LowCategory implements Serializable {
	private static final long serialVersionUID = 8688945357248683029L;

	private String categoryId;
	private String name; //图书类别名称
	private TopCategory parent; //父类别
	private Set<Book> books = new HashSet<Book>();;;
	
	public LowCategory() {
		
	}
	public LowCategory(String categoryId) {
		this.categoryId = categoryId;
	}
	public LowCategory(String categoryId, String name, TopCategory parent, Set<Book> books) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.parent = parent;
		this.books = books;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TopCategory getParent() {
		return parent;
	}
	public void setParent(TopCategory parent) {
		this.parent = parent;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
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
		LowCategory other = (LowCategory) obj;
		if (categoryId == null) {
			if (other.categoryId != null)
				return false;
		} else if (!categoryId.equals(other.categoryId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
}
