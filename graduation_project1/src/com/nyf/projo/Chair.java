package com.nyf.projo;

import java.util.Date;

public class Chair {
	private Integer id;
	private Date activity_time;
	private String description;
	private String chair_professor;
	private String address;
	private Date release_time;
	private Integer status;
	private int login_id;
	
	
	public int getLogin_id() {
		return login_id;
	}
	public void setLogin_id(int login_id) {
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
	public void setChair_professor(String chair_professor) {
		this.chair_professor = chair_professor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getActivity_time() {
		return activity_time;
	}
	public void setActivity_time(Date activity_time) {
		this.activity_time = activity_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getChair_professor() {
		return chair_professor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRelease() {
		return release_time;
	}
	public void setRelease(Date release_time) {
		this.release_time = release_time;
	}
	@Override
	public String toString() {
		return "Chair [id=" + id + ", activity_time=" + activity_time + ", description=" + description
				+ ", chair_professor=" + chair_professor + ", address=" + address + ", release_time=" + release_time + "]";
	}
	
	
}
