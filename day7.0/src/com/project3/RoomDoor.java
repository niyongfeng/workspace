package com.project3;

public class RoomDoor extends Door implements Waterproof, Fireproof{
	
	public RoomDoor() {
		
	}
	
	public String waterproof() {
		return "防水";
	}
	
	public String fireproof() {
		return "防火";
	}
	
	public String toString() {
		return "房间门具有以下属性：" + waterproof() + ", " + fireproof() + " ;";
	}

}
