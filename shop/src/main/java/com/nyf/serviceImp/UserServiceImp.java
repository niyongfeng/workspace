package com.nyf.serviceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nyf.dao.UserDao;
import com.nyf.pojo.User;
import com.nyf.service.UserService;
@Service("userService")
public class UserServiceImp implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public List<User> login(User user) {
		System.out.println(userDao);
		return userDao.selectByLogin(user);
	}

	@Override
	public boolean register(User user) {
		return userDao.insertLogin(user);
	}

}
