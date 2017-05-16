package com.nyf.service;

import java.util.List;

import com.nyf.pojo.User;

public interface UserService {
	List<User> login(User user);
	boolean register(User user);
}
