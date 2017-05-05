package com.domain.dao;

import java.util.List;

public interface BaseDao {
	void insert(Object ob);
	void delete(Object ob);
	Object update(Object ob);
	List selectAll();
	Object selectById(int id);
}
