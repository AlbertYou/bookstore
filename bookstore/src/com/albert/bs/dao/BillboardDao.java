package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.Billboard;

public interface BillboardDao extends BaseDao<Billboard, String> {

	//获得当前公告标题
	public List<Billboard> getCurrentBillboards();
	
	//隐藏公告
	public void hid(String billboardId);
	
	//获得所有公告
	public List<Billboard> getAllBillboards(int start, int count);
	
	
}
