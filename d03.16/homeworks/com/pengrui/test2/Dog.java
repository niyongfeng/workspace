package com.pengrui.test2;

public class Dog {
	private String dogName = "lll";
	private int dogAge = 0;
	public Person owner;
	public Dog() {
		
	}
	
	public Dog(String n, int a) {
		dogName = n;
		dogAge = a;
	}

	
	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public int getDogAge() {
		return dogAge;
	}

	public void setDogAge(int dogAge) {
		this.dogAge = dogAge;
	}
	
	public String toString() {
		return  "DogName:" + dogName + ", DogAge:" + dogAge;
	}
}
