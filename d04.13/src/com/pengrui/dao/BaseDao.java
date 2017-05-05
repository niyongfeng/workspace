package com.pengrui.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

public interface BaseDao {
	void delete(Object obj);
	void update(Object obj);
	void insert(Object obj);
	List select(Object obj);
	//@Select("select * from project where code = #{id};")
	List selectById(int id);
}
