package com.pengrui.test13;

public class StudentInfo {
	private int id;
	private String name;
	private int age;
		
	public StudentInfo(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "Id:" + getId() + ",Name:" + getName() + ",Age:" + getAge();
	}
}
