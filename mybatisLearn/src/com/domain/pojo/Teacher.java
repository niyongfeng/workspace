package com.domain.pojo;

public class Teacher {
	private int id;
	private String name;
	private String phone;
	private Clazz clazz;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", phone=" + phone + ", clazz=" + clazz + "]";
	}

}
