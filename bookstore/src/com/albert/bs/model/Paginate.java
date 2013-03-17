package com.albert.bs.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * paging infomation
 * 
 * @author Albert
 * @param <POJO>
 *            the content in page
 * @version V1.0 2012-03-25
 * @since JDK5.0
 */
public class Paginate<POJO> implements Serializable {
	private static final long serialVersionUID = -5108079477626369635L;
	
	private int allRecords = 0;
	private int recordInPage = 30;
	private int allPages = 0;
	private int currentPage = 1;
	private List<POJO> list;
	
	public int getAllRecords() {
		return allRecords;
	}
	public void setAllRecords(int allRecords) {
		this.allRecords = allRecords;
	}
	public int getRecordInPage() {
		return recordInPage;
	}
	public void setRecordInPage(int recordInPage) {
		this.recordInPage = recordInPage;
	}
	public int getAllPages() {
		return allPages;
	}
	public void setAllPages(int allPages) {
		this.allPages = allPages;
	}
	public int getCurrentPage() {
		if(currentPage > getAllPages()) {
			setCurrentPage(allPages);
		}
		if(currentPage < 1) {
			setCurrentPage(1);
		}
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<POJO> getList() {
		if(list == null) {
			list = new ArrayList<POJO>();
		}
		return list;
	}
	public void setList(List<POJO> list) {
		this.list = list;
	}
	
}
