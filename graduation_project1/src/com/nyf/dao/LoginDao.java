package com.nyf.dao;

import java.util.List;

import com.nyf.projo.Login;

public interface LoginDao extends BaseDao {
	List<Login> selectByStatus(int status);
	List<Login> selectByCode(int code);
	List<Login> selectByName(String name);
	List<Login> selectByLogin(Login login);
	List<Login> selectByLogin_id(int id);
	boolean updateByName(Login l);
	List<Login> selectByString(String str);
	List<Login> selectByNameA(String name);
}
