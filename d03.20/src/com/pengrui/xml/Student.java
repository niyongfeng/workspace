package com.pengrui.xml;

import java.io.Serializable;

public class Student implements Serializable{
	private String name;
	private String gender;
	private transient int age;
	
	public Student(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString() {
		return "name:" + name + ",gender:" + gender + ",age:" + age;
	}
}
