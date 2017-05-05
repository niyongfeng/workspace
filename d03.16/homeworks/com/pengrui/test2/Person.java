package com.pengrui.test2;

public class Person {
	public String personName = "nnn";
	public int personAge = 0;
	
	public Person() {
		
	}

	public Person(String n, int a) {
		personName = n;
		personAge = a;
	}
	
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public int getPersonAge() {
		return personAge;
	}

	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}

	public String toString() {
		return "PersonName:" + getPersonName() + ", PersonAge:" + getPersonAge();
	}
}
