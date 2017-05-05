package com.pengrui.object;

public class Person{
	private String name;
	private int age;
	private Dog pet;
	
	public Person() {
		
	}
	
	public Person(String name, int age, Dog pet) {
		this.name = name;
		this.age = age;
		this.pet = pet;
	}
	
	public String toString() {
		return "Person [ Name:" + name + ",Age:" + age + ",Dog:" + pet.toString() + " ]";
	}
	
	
	public Object clone() {
		Dog dog = new Dog(pet.name, pet.weight);
		Person p = new Person(this.name, this.age, dog);
		return p;
	}
	
	public static void main(String[] args) {
		Dog dog = new Dog("旺财", 40);
		Person p1 = new Person("niyongfeng", 26, dog);
		Person p2 = (Person)p1.clone();
		System.out.println(p1.equals(p2));
		System.out.println(p1.toString());
		p2.pet.name = "大黄";
		System.out.println(p2.toString());
		System.out.println(dog.getClass());

	}
}
