package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.AdminDao;
import com.albert.bs.model.Admin;
import com.albert.bs.service.AdminService;

public class AdminServiceImpl implements AdminService {

	private AdminDao dao;
	
	public void delete(Admin admin) {
		dao.delete(admin);
	}

	public Admin findByName(String adminName) {
		return dao.findByName(adminName);
	}
	
	public Admin findById(String adminId) {
		return dao.findById(adminId);
	}

	public List<Admin> findAll() {
		return dao.findAll();
	}
	
	public void save(Admin admin) {
		dao.save(admin);
	}

	public Admin resetPassword(Admin admin) {
		return dao.resetPassword(admin);
	}
	
	public Admin login(Admin admin) {
		return dao.login(admin);
	}

	public AdminDao getDao() {
		return dao;
	}
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

}
