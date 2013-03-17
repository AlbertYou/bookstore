package com.albert.bs.daoimpl;

import java.util.List;

import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.albert.bs.constant.UserStatus;
import com.albert.bs.dao.UserDao;
import com.albert.bs.model.User;

public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	public void changeStatus(String userId) {
		User user = (User) getHibernateTemplate().get(User.class, userId);
		if(user.getStatus() == UserStatus.NORMAL) {
			user.setStatus(UserStatus.STOPPED);
		} else {
			user.setStatus(UserStatus.NORMAL);			
		}
		getHibernateTemplate().update(user);
	}

	public int findUserCount(String username) {
		return (Integer) getSession(false).createCriteria(User.class).setProjection(Projections.rowCount()).add(Restrictions.like("username", "%" + username + "%")).uniqueResult();
	}
	@SuppressWarnings("unchecked")
	public List<User> findUser(String username, int start, int count) {
		return getSession(false).createCriteria(User.class).add(Restrictions.like("username", "%" + username + "%")).setFirstResult(start).setMaxResults(count).list();
	}

	public void update(User user) {
		User u = (User) getHibernateTemplate().get(User.class, user.getUserId());
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		u.setPassword(user.getPassword());
		u.setSex(user.getSex());
		u.setPhone(user.getPhone());
		getHibernateTemplate().update(u);
	}

	public User login(String username, String password) {
		User user = null;
		user = (User) getSession(false).createCriteria(User.class).add(Restrictions.or(Restrictions.eq("username", username), Restrictions.eq("email", username))).add(Restrictions.eq("password", password)).uniqueResult();
		if(user != null && user.getUserId() != null && !user.getUserId().equals("")) {
			return user;
		}
		return null;
	}
	
	public User findPassword(String username, String email) {
		User user = null;
		user = (User) getSession(false).createCriteria(User.class).add(Restrictions.eq("username", username)).add(Restrictions.eq("email", email)).uniqueResult();
		if(user != null && user.getUserId() != null && !user.getUserId().equals("")) {
			return user;
		}
		return null;
	}

	public boolean existUsername(String username) {
		User user = null;
		user = (User) getSession(false).createCriteria(User.class).add(Restrictions.eq("username", username)).uniqueResult();
		if(user != null) {
			return true;
		}
		return false;
	}

	public boolean existEmail(String email) {
		User user = null;
		user = (User) getSession(false).createCriteria(User.class).add(Restrictions.eq("email", email)).uniqueResult();
		if(user != null) {
			return true;
		}
		return false;
	}

}
