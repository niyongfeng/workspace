package com.pengrui.people;

import com.pengrui.animals.Dog;
import com.pengrui.products.Phone;

public class Person {
	
	private String name;
	private int age;
	private String idNumber;
	public Phone[] phones;
	public Dog[] dogs;
	
	public Person() {
		
	}
	
	public Person(String name, int age, String idNumber) {
		this.name = name;
		this.age = age;
		this.idNumber = idNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getIdNumber() {
		return idNumber.substring(0, 14) + "****";
	}
	
	private void increaseAge() {
		age = age + 1;
	}
	
	public void birthday() {
		increaseAge();
	}
	
	public String toString() {
		System.out.println("Person : name: " + name + ", age:" + age + ", idNumeber:" + getIdNumber());
		int n = 1, m = 1; 
		if(dogs != null) {
			for(Dog d : dogs) {
				System.out.println("MyDog" + n + ": " + d.toString());
				n++;
			}
		}
		if(phones != null) {
			for(Phone p : phones) {
				System.out.println("MyPhone" + m + ": " + p.toString());
				m++;
			}
		}
		return "";
	}

}
