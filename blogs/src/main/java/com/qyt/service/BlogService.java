package com.qyt.service;

import java.util.List;

import com.qyt.pojo.Blog;

public interface BlogService {
	public boolean insert(Blog blog);
	public boolean delete(Blog Blog);
	public boolean update(Blog Blog);
	public Blog selectById(int id);
	public List<Blog> selectByType(String type);
	public List<Blog> select();
}
