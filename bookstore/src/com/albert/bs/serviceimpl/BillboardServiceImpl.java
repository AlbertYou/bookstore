package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.BillboardDao;
import com.albert.bs.model.Billboard;
import com.albert.bs.service.BillboardService;

public class BillboardServiceImpl implements BillboardService {

	private BillboardDao dao;

	public void delete(Billboard billBoard) {
		dao.delete(billBoard);
	}
	public Billboard findById(String billboardId) {
		return dao.findById(billboardId);
	}
	public void save(Billboard billBoard) {
		dao.save(billBoard);
	}
	public void update(Billboard billBoard) {
		dao.update(billBoard);
	}
	public void hid(String billboardId) {
		dao.hid(billboardId);
	}
	public List<Billboard> getAllBillboards(int start, int count) {
		return dao.getAllBillboards(start, count);
	}
	public List<Billboard> getCurrentBillboards() {
		return dao.getCurrentBillboards();
	}
	public int count() {
		return dao.count();
	}
	
	public BillboardDao getDao() {
		return dao;
	}
	public void setDao(BillboardDao dao) {
		this.dao = dao;
	}
	
}
