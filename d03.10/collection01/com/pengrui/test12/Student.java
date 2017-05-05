package com.pengrui.test12;

public class Student {
	private String classNum;
	private String name;
	private int age;
	private int scores;
	
	public Student(String name, int age, int scores, String classNum) {
		this.name = name;
		this.age = age;
		this.scores = scores;
		this.classNum = classNum;
	}
	
	
	public String getClassNum() {
		return classNum;
	}


	public void setClassNum(String classNum) {
		this.classNum = classNum;
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


	public int getScores() {
		return scores;
	}


	public void setScores(int scores) {
		this.scores = scores;
	}


	public String toString() {
		return "Name:" + name + ",Age" + age + ",Scores:" + scores + ",ClassNum:" + classNum;
	}
}
