package com.pengrui.animals;

public class Dog extends Animals{
	private final String DOG = "I'am a big dog!";
	
	public Dog(String name) {
		System.out.println("zi");
	}
	
	public Dog(String name, int age, String owner) {
		super(name, age, owner);
	}
			
	public String toString() {
		return DOG;
	}
}
