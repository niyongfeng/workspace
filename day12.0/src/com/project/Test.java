package com.project;

public class Test {

	public static void main(String[] args) {
		A a1 = new A(1, 2);
		A a2 = new A(1.0, 2.0, 3.0);
		A a3 = new A("AB", "CD");
		A a4 = new A("AB", "AB");
		
		System.out.println(1 ^ 0);
		System.out.println(1 ^ 1);
	}
}
