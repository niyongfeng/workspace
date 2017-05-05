package com.nyf.projo;

import java.util.Date;

public class VolunteerActivity {
	private Integer id;
	private Date activity_time;
	private String description;
	private Integer number;
	private String address;
	private Date release_time;
	private Integer status;
	private Integer login_id;
	private double credit;
	private int count;
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	@Override
	public String toString() {
		return "VolunteerActivity [id=" + id + ", activity_time=" + activity_time + ", description=" + description
				+ ", number=" + number + ", address=" + address + ", release_time=" + release_time + ", status="
				+ status + ", login_id=" + login_id + ", credit=" + credit + ", count=" + count + "]";
	}
	
	
}
