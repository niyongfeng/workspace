package com.qingke.test;

public class Info {
	private String id1;
	private String name;
	private int salary;
	private String id2;
	private String area;
	
	public Info() {
		
	}
	
	public Info(String id1, String area, int salary, String id2, String name) {
		this.id1 = id1;
		this.area = area;
		this.salary = salary;
		this.id2 = id2;
		this.name = name;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getId2() {
		return id2;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	public String toString() {
		return getId1() + "," + getArea() + "," + getSalary() + "," + getId2() + "," + getName();
	}
}
