package com.albert.bs.service;

import java.util.List;

import com.albert.bs.model.User;

public interface UserService {

	public User findById(String userId);

	public List<User> findPaginate(int start, int count);

	public List<User> findAll();
	
	public void save(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public int count();
	
	public int findUserCount(String username);
	public List<User> findUser(String username, int start, int count);
	
	public void changeStatus(String userId);
	
	public User login(String username, String password);
	
	public User findPassword(String username, String email);
	
	public boolean existUsername(String username);
	
	public boolean existEmail(String email);
}
