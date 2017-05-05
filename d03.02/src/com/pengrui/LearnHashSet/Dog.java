package com.pengrui.LearnHashSet;


public class Dog implements Comparable<Dog>{
	
	private String name;
	private String ower;
	public int age;
	
	public Dog(String name, String ower,int age) {
		this.name = name;
		this.ower = ower;
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Dog)) return false;
		
		Dog d = (Dog) obj;
		//return d.name == name && d.ower == ower;
		return d.hashCode() == this.hashCode();
	}
	
	public int hashCode() {
		String s = name + ower;
		return s.hashCode();
	}
	
	public String toString() {
		return name + ":" + ower + ":" + age;
	}

	//如果对象相等，返回0
	//如果对象大，返回1
	//如果对象小，返回-1
	public int compareTo(Dog o) {
		return name.compareTo(o.name);
	}



}
