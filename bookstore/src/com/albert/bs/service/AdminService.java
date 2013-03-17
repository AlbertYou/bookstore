package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.Admin;

public interface AdminService {

	public Admin findById(String adminId);

	public List<Admin> findAll();
	
	public Admin findByName(String adminName);

	public void save(Admin admin);
	
	public Admin resetPassword(Admin admin);
	
	public void delete(Admin admin);
	
	public Admin login(Admin admin);
	
}
