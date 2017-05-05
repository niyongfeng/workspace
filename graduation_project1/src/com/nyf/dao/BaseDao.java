package com.nyf.dao;

import java.util.List;

import com.nyf.projo.Chair;
@SuppressWarnings("rawtypes")
public interface BaseDao {
	List selectAll();
	List selectAllByman();
	List select(Object obj);
	List selectByString(String str);
	List selectByLogin_id(int i);
	List selectById(int id);
	boolean insert(Object obj);
	boolean update(Object obj);
	boolean delete(int id);
	List selectByStringAndLoginId(String str);
}
