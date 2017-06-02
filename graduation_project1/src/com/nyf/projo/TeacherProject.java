package com.nyf.projo;

import java.util.Date;

public class TeacherProject {
	private Integer id;
	private String name;
	private String teacher;
	private Integer number;
	private String description;
	private Date release_time;
	private Integer status;
	private Integer login_id;
	
	
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(!("".equals(name))) {
		this.name = name;
		}
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		if(!("".equals(teacher))) {
		this.teacher = teacher;
		}
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		if(!("".equals(description))) {
		this.description = description;
		}
	}
	@Override
	public String toString() {
		return "TeacherProject [id=" + id + ", name=" + name + ", teacher=" + teacher + ", number=" + number
				+ ", description=" + description + ", release_time=" + release_time + ", status=" + status + "]";
	}
	
	
}
