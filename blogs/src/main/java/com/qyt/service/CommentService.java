package com.qyt.service;

import java.util.List;

import com.qyt.pojo.Comment;

public interface CommentService {
	public boolean insert(Comment comment);
	public List<Comment> selectByBlogId(int blog_id);
}
