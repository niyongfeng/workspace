package com.pengrui.test5;

public class Person {
	private String name;
	private int age;
	
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
	}
}
