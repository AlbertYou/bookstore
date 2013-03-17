package com.albert.bs.dao;

import com.albert.bs.model.Admin;

public interface AdminDao extends BaseDao<Admin, String> {

	public Admin findByName(String adminName);
	
	public Admin login(Admin admin);

	public Admin resetPassword(Admin admin);
	
}
