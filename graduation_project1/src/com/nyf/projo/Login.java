package com.nyf.projo;

public class Login {
	private Integer id;
	private String name;
	private String pwd;
	private Integer code;
	private Integer status;
	
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
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "Login [id=" + id + ", name=" + name + ", pwd=" + pwd + ", code=" + code + "]";
	}
	
	
}
