package com.test6;

public class BaseTeacher extends Teacher{
	
	private int salary;

	public BaseTeacher() {
		
	}
	
	public BaseTeacher(String name, int age, boolean teach) {
		super(name,age,teach);
	}
	
	public BaseTeacher(String name, int age, boolean teach, int salary) {
		super(name,age,teach);
		this.salary = salary;
	}
	
	public String toString() {
		return "BaseTeacher: name = " + super.getName() + ", age = " + super.getAge() + ", teach = " + super.getTeach() + ", salary = " + salary;
	}
	
	
	
	
}
