package com.albert.bs.serviceimpl;

import java.util.List;

import com.albert.bs.dao.UserDao;
import com.albert.bs.model.User;
import com.albert.bs.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao dao;

	public void delete(User user) {
		dao.delete(user);
	}
	public List<User> findAll() {
		return dao.findAll();
	}
	public User findById(String userId) {
		return dao.findById(userId);
	}
	public List<User> findPaginate(int start, int count) {
		return dao.findPaginate(start, count);
	}
	public void save(User user) {
		dao.save(user);
	}
	public void update(User user) {
		dao.update(user);
	}
	
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public void changeStatus(String userId) {
		dao.changeStatus(userId);
	}
	public int findUserCount(String username) {
		return dao.findUserCount(username);
	}
	public List<User> findUser(String username, int start, int count) {
		return dao.findUser(username, start, count);
	}
	public int count() {
		return dao.count();
	}
	public User login(String username, String password) {
		return dao.login(username, password);
	}
	public User findPassword(String username, String email) {
		return dao.findPassword(username, email);
	}
	public boolean existUsername(String username) {
		return dao.existUsername(username);
	}
	public boolean existEmail(String email) {
		return dao.existEmail(email);
	}
}
