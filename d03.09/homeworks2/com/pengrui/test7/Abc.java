package com.pengrui.test7;

public class Abc {
	public Abc(int a, int b) {
		System.out.println(a > b ? a : b);
	}
	
	public Abc(double a, double b, double c) {
		System.out.println(a * b * c);
	}
	
	public Abc(String a, String b) {
		System.out.println(a.equals(b));
	}
	
	public static void main(String[] args) {
		Abc a1 = new Abc(1,2);
		Abc a2 = new Abc(1.0, 2.0, 3.0);
		Abc a3 = new Abc("abc", "abc");
		Abc a4 = new Abc("abc", "bcd");
	}
}
