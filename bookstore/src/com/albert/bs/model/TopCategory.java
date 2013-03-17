package com.albert.bs.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 一级图书类别
 * 
 * @author Albert
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class TopCategory implements Serializable {
	private static final long serialVersionUID = 8688945357248683029L;

	private String categoryId;
	private String name; //图书类别名称
	private Set<LowCategory> children = new HashSet<LowCategory>();; //子类别
	
	public TopCategory() {
		super();
	}
	public TopCategory(String categoryId) {
		super();
		this.categoryId = categoryId;
	}
	public TopCategory(String categoryId, String name, Set<LowCategory> children) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.children = children;
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
	public Set<LowCategory> getChildren() {
		return children;
	}
	public void setChildren(Set<LowCategory> children) {
		this.children = children;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoryId == null) ? 0 : categoryId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		TopCategory other = (TopCategory) obj;
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
		return true;
	}
	@Override
	public String toString() {
		return "Category [name=" + name + "]";
	}
	
}
