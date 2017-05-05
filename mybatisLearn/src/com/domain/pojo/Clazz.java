package com.domain.pojo;

import java.util.List;

public class Clazz {
	private int id;
	private String name;
	private Teacher teacher;
	private List<Student> students;	

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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public List<Student> getSutdents() {
		return students;
	}

	public void setSutdents(List<Student> sutdents) {
		this.students = sutdents;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", name=" + name + ", teacher=" + teacher + ", sutdents=" + students + "]";
	}

	
	
}
