package com.project3;

public class GateDoor extends Door implements Theftproof, Rustproof, Waterproof{
	
	public GateDoor() {
		
	}
	
	public String theftproof() {
		return "防盗";
	}
	
	public String rustproof() {
		return "防锈";
	}
	
	public String waterproof() {
		return "防水";
	}
	
	public String toString() {
		return "大门具有以下功能：" + theftproof() + ", " + rustproof() + ", " + waterproof() + " ;";
	}
	

}
