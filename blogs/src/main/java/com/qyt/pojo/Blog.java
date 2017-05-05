package com.qyt.pojo;

import java.util.Date;

public class Blog {
	private int id;
	private String title;
	private String description;
	private Date time;
	private String type;
	private int page_view;
	private int thumb;
	private int  user_id;
	private User user;
	
	public Blog() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTime() {
		return time;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getPage_view() {
		return page_view;
	}
	public void setPage_view(int page_view) {
		this.page_view = page_view;
	}
	public int getThumb() {
		return thumb;
	}
	public void setThumb(int thumb) {
		this.thumb = thumb;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", description=" + description + ", time=" + time + ", type="
				+ type + ", page_view=" + page_view + ", thumb=" + thumb + ", user_id=" + user_id + ", user=" + user
				+ "]";
	}
	
	
}
