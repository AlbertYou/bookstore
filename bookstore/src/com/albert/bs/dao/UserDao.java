package com.albert.bs.dao;

import java.util.List;

import com.albert.bs.model.User;

public interface UserDao extends BaseDao<User, String> {

	//查找用户
	public int findUserCount(String username);
	public List<User> findUser(String username, int start, int count);
	
	//停用/启用用户状态
	public void changeStatus(String userId);
	
	//登录(用户名或密码登录)
	public User login(String username, String password);

	//忘记密码
	public User findPassword(String username, String email);

	//判断用户名是否存在
	public boolean existUsername(String username);
	
	//判断邮箱是否存在
	public boolean existEmail(String email);
	
}
