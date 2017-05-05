package com.domain.dao;

import java.util.List;

import com.domain.pojo.Student;

public interface StudentDao extends BaseDao {
	List<Student> selectByClazzId(int id);
}
