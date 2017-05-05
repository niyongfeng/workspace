package com.pengrui.animals;

public abstract class Animals {
	
	private String name;
	private int age;
	private String owner;
	
	public Animals() {
		System.out.println("fu");
	}
	
	public Animals(String name, int age, String owner) {
		this.name = name;
		this.age = age;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void run() {
		System.out.println(name + "开始跑步。。。。");
		System.out.println(name + "跑步结束。。。。");
	}
	
	public void eat() {
		System.out.println(name + "开始吃饭。。。。");
		System.out.println(name + "已经吃饱。。。。");
	}
	
	public abstract String toString();
	
	public String information() {
		return "name: " + name + " ,age: " + age + ",owner: " + owner;
	}

}
