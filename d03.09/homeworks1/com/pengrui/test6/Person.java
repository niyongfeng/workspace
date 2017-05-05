package com.pengrui.test6;

public class Person {
	private String name;
	private int age;
	
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

	public Person() {
		
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void display() {
		System.out.println("Person:Name:" + name + ",Age:" + age);
	}
	
	public static void main(String[] args) {
		Person p = new Person("niyongfeng", 26);
		p.display();
		p.setAge(25);
		p.setName("nyf");
		p.display();
	}
}
