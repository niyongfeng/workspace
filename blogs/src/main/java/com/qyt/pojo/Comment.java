package com.qyt.pojo;

public class Comment {
	private int id;
	private String description;
	private int blog_id;
	private Blog blog;
	public Comment() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBlog_id() {
		return blog_id;
	}
	public void setBlog_id(int blog_id) {
		this.blog_id = blog_id;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", description=" + description + ", blog_id=" + blog_id + ", blog=" + blog + "]";
	}
	
	
}
