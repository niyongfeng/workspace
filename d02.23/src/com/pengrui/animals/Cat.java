package com.pengrui.animals;

public class Cat extends Animals{
	private final String CAT = "I'am a small cat!";
	
	public Cat() {
		
	}
	
	public Cat(String name, int age, String owner) {
		super(name, age, owner);
	}
	public String toString() {
		return CAT;
	}

}
