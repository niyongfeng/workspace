package com.pengrui.worker;

import java.util.HashSet;
import java.util.Set;

public class Worker {
	public String name;
	public int age;
	public double salary;
	public Set<Worker> set = new HashSet<Worker>();
	
	public Worker() {
		
	}
	
	public Worker(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	public void work() {
		System.out.println("#" + name + "#开始工作了。。。");
		System.out.println("#" + name + "#完成工作了。。。");
	}
	
	public String toString() {
		return "Worker: name:" + name + ",age:" + age + ",salary:" + salary;
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Worker)) return false;
		
		Worker w = (Worker) obj;
		return w.hashCode() == this.hashCode();
	}
	
	public int hashCode() {
		String str = name + age + salary;
		return str.hashCode();
	}
}
