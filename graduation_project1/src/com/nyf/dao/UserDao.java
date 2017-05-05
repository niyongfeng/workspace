package com.nyf.dao;

import java.util.List;

import com.nyf.projo.User;

public interface UserDao extends BaseDao{
	List<User> selectByStatus(int status);
	List<User> selectByStudentNumber(String number);
	List<User> selectByName(String name);
	List<User> selectByGender(String gender);
	List<User> selectByMajor(String major);
	List<User> selectByPhone(String phone);
	List<User> selectByEmail(String email);
	
}
