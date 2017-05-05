package com.qing.pojo;

public class Location {
	
	private String name;
	private String country;
	private String path;
	private String timezone;
	private String timezone_offset;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getTimezone_offset() {
		return timezone_offset;
	}
	public void setTimezone_offset(String timezone_offset) {
		this.timezone_offset = timezone_offset;
	}

	@Override
	public String toString() {
		return "Location [name=" + name + ", country=" + country + ", path=" + path + ", timezone=" + timezone
				+ ", timezone_offset=" + timezone_offset + "]";
	}
	
	
}
