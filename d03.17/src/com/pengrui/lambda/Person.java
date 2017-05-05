package com.pengrui.lambda;

public class Person {
	private String name;
	private String department;
	private int score;
	
	public Person() {
		
	}
	
	public Person(String n, String d, int s) {
		name = n;
		department = d;
		score = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
