package com.pengrui.object;

public class Project {
	private String code = "";
	private String name = "";
	private String description = "";
	private String datetimes = "";
	private int userId = 0;
	
	public Project() {
		
	}
	public Project(String code, String name, String description,int userId) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.userId = userId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDatetimes() {
		return datetimes;
	}
	public void setDatetimes(String datetimes) {
		this.datetimes = datetimes;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	@Override
	public String toString() {
		return "Project [code=" + code + ", name=" + name + ", description=" + description + ", datetimes=" + datetimes
				+ ", userId=" + userId + "]";
	}
	
	
}
