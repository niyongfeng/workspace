package com.pengrui.employee;

public class TestEmployee {

	public static void main(String[] args) {
		Employee employee1 = new Employee();
		System.out.println(employee1.toString());
		employee1.setSalary(10000);
		System.out.println("AunnualSalay = " + employee1.getAnnualSalary());
		System.out.println(employee1.raiseSalary(50));
		
		Employee employee2 = new Employee(110, "qie", "yanteng", 88888);
		System.out.println(employee2.toString());
	}
}
