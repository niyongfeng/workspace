package com.project3;

public class SafeDoor extends Door implements Theftproof, Bulletproof, Fireproof, Rustproof, Waterproof{
	
	public SafeDoor() {
		
	}
	
	public String theftproof() {
		return "防盗";
	}
	
	public String bulletproof() {
		return "防弹";
	}
	
	public String fireproof() {
		return "防火";
	}
	
	public String rustproof() {
		return "防锈";
	}
	
	public String waterproof() {
		return "防水";
	}
	
	public String toString() {
		return "保险柜门具有以下属性：" + theftproof() + ", " + bulletproof() + ", " + fireproof() + ", " + rustproof() + ", " + waterproof() + " ;";
	}

}
