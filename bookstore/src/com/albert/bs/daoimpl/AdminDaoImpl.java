package com.albert.bs.daoimpl;

import org.hibernate.criterion.Restrictions;

import com.albert.bs.dao.AdminDao;
import com.albert.bs.model.Admin;

public class AdminDaoImpl extends BaseDaoImpl<Admin, String> implements AdminDao {
	
	public Admin findByName(String adminName) {
		return (Admin) getSession(false).createCriteria(Admin.class).add(Restrictions.eq("adminName", adminName)).uniqueResult();
	}

	public Admin login(Admin admin) {
		return (Admin) getSession(false).createCriteria(Admin.class).add(
				Restrictions.eq("adminName", admin.getAdminName())).add(
				Restrictions.eq("password", admin.getPassword()))
				.uniqueResult();
	}

	public Admin resetPassword(Admin admin) {
		Admin a = (Admin) getHibernateTemplate().load(Admin.class, admin.getAdminId());
		a.setPassword(admin.getPassword());
		getHibernateTemplate().update(a);
		return a;
	}

}
