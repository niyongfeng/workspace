package com.test6;

public abstract class Teacher {
	
	private String name = " ";
	private int age = 25;
	private boolean teach = true;
	
	public Teacher() {
		
	}
	
	public Teacher(String name, int age, boolean teach) {
		this.name = name;
		this.age = age;
		this.teach = teach;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setTeach(boolean teach) {
		this.teach = teach;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public boolean getTeach() {
		return teach;
	}
	
	public abstract String toString();

}
