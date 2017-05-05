package com.pengrui.employee;

public class Employee {
	
	private int id = 110708132;
	private String firstName = "ni";
	private String lastName = "yongfeng";
	private int salary = 9999999;
	
	public Employee() {
		
	}
	
	public Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return getFirstName() + getLastName();
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getAnnualSalary() {
		return salary * 12;
	}
	
	public int raiseSalary(int percent) {
		return salary * (100 + percent) / 100;
	}
	
	public String toString() {
		return "Employee [ id = " + id + ", name =" + getName() + ", salary = " + salary + " ]";
	}
}
