package com.overload_overwrite;

public class Father {
	
	private String surName = "ni";
	private int property = 100000000; 
	
	public Father() {
		
	}
	
	public Father(String surName, int property) {
		this.surName = surName;
		this.property = property;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public int getProperty() {
		return property;
	}
	
	public String toString() {
		return "Father [ name = " + surName + ", property = " + property + " ]";
	}

}
