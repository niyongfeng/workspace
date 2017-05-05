package com.nyf.projo;

import java.util.Date;

public class Competition {
	private Integer id;
	private Date activity_time;
	private String description;
	private Date apply_time;
	private String address;
	private Integer status;
	private Integer login_id;
	
	public Integer getLogin_id() {
		return login_id;
	}
	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public Date getApply_time() {
		return apply_time;
	}
	public void setApply_time(Date apply_time) {
		this.apply_time = apply_time;
	}
	@Override
	public String toString() {
		return "Competition [id=" + id + ", activity_time=" + activity_time + ", description=" + description
				+ ", apply_time=" + apply_time + ", address=" + address + "]";
	}
	
	
	
}
