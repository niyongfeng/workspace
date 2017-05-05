package com.qyt.service;

import java.util.List;

import com.qyt.pojo.User;

public interface UserService {
	public boolean insertUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUserName(User user);
	public boolean updateUserPassword(User user);
	public List<User> selectByUserId(int id);
	public List<User> selectByUserLoginName(User user);
	public List<User> selectByUserName(User user);
	public List<User> selectIsLogin1(User user);
}
