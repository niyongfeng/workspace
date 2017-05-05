package com.qyt.dao;

import java.util.List;

import com.qyt.pojo.Comment;

public interface CommentDao {
	public int insert(Comment comment);
	public List<Comment> selectByBlogId(int blog_id);
}
