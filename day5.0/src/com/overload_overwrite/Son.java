package com.overload_overwrite;

public class Son extends Father{
	
	private String name = "yongfeng";
	//private Father father = new Father();
	
	public Son() {
		
	}
	
	public String toString() {
		return "Son [ name = " + super.getSurName() + "" + name + ", property = " + super.getProperty() + " ]";
	}

}
