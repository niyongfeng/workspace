package com.project3;

public abstract class Door {
	
	public Door() {
		
	}
	
	public String openDoor() {
		return "开已门";
	}
	
	public String closeDoor() {
		return "门已关";
	}
	
	public abstract String toString();

}
