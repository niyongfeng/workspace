package com.keyword;

public class Static {
	
	private String name;
	//private int age1 = 10;
	private static int age;
	
	public Static() {
		
	}
	
	public Static(String name, int age) {
		Static.age = age;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public static int getAge1() {
		//return age1; 会报错，静态的方法只能调用静态的变量；
		return age;
	}
	
	public int getAge2() {
		return age; //非静态的方法可以调用静态的变量；
	}
	
	
	
}
