package com.pengrui.object;

public class Dog implements Cloneable{
	public String name;
	public double weight;
	
	public Dog() {
		
	}
	
	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}
	
	public String toString() {
		return "Dog[name:" + name + ",weight:" + weight + "kg]";
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Dog)) return false;
		
		Dog d = (Dog) obj;
		return d.name == this.name && d.weight == this.weight;
	}
	
	public int hashCode() {
		String s = name + weight;
		return s.hashCode();
	}
	
	public static void main(String[] args) {
		Dog gg = new Dog("sada", 12);
		try {
			Dog hh = (Dog)gg.clone();
			System.out.println(hh.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
