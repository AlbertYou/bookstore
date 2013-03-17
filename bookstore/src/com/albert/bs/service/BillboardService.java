package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Billboard;

public interface BillboardService {

	public Billboard findById(String billboardId);

	public List<Billboard> getAllBillboards(int start, int count);
	
	public void save(Billboard billBoard);
	
	public void update(Billboard billBoard);
	
	public void delete(Billboard billBoard);
	
	public List<Billboard> getCurrentBillboards();
	
	public void hid(String billboardId);

	public int count();
	
}
