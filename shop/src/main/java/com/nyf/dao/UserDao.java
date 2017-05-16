package com.nyf.dao;

import java.util.List;

import com.nyf.pojo.User;

public interface UserDao {
	List<User> select(User user);
	List<User> selectByLogin(User user);
	boolean insertLogin(User user);
}