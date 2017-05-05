package com.pengrui.test4;

public class Addition {
	
	public Addition(int a, int b) {
		System.out.println(a + b);
	}
	
	public Addition(long a, long b) {
		System.out.println(a + b);
	}
	
	public Addition(double a, double b) {
		System.out.println(a + b);
	}
	
	public Addition(String a, String b) {
		System.out.println(a + b);
	}
	
	public static void main(String[] args) {
		Addition a1 = new Addition(1,2);
		Addition a2 = new Addition(1000000,2000000);
		Addition a3 = new Addition(1.0, 2.0);
		Addition a4 = new Addition("abc", "def");
	}
}
