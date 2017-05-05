package com.qyt.dao;

import java.util.List;

import com.qyt.pojo.User;

public interface UserDao {
	public int insert(User user);
	public int delete(User user);
	public int updateName(User user);
	public int updatePassword(User user);
	public List<User> selectById(int id);
	public List<User> selectByLoginName(User user);
	public List<User> selectByName(User user);
	public List<User> selectIsLogin(User user);
}
