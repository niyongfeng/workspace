package com.nyf.dao;

import java.util.List;

import com.nyf.pojo.Tag;

public interface TagDao {
	List<Tag> selectTagById(int id);
	List<Tag> selectTagAll();
}
