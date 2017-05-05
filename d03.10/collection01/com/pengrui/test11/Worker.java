package com.pengrui.test11;

//import java.util.Iterator;

public class Worker {
	private final Long id;
	private String name;
	private double salary;
	private int age;
	
	public Worker() {
		id = (long)(Manage.list.size() + 1);
	}
	
	public Worker(String name, int age, double salary) {
		id = (long)(Manage.list.size() + 1);
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Worker)) {
			return false;
		}
//		boolean f = false;
		Worker worker = (Worker) obj;
		return worker.getId() == getId();
//		Iterator<Worker> it = Manage.list.iterator();
//		while(it.hasNext()) {
//			if(worker.getId() == it.next().getId()) {
//				f = true;
//				break;
//			}
//		}
//		return f;
		
	}
	
	
	public int hashCode() {
		String str = name + id + age;
		return str.hashCode();
	}
	
	public String toString() {
		return "ID:" + getId() + ",Name:" + getName() + ",Age:" + getAge() + ",Salary:" + getSalary();
	}
	

}
