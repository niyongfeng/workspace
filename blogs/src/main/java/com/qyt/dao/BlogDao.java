package com.qyt.dao;

import java.util.List;

import com.qyt.pojo.Blog;

public interface BlogDao {
	public int insert(Blog blog);
	public int delete(Blog Blog);
	public int update(Blog Blog);
	public Blog selectById(int id);
	public List<Blog> selectByType(String type);
	public List<Blog> select();
	
}
