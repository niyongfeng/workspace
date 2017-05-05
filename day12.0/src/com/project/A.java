package com.project;

public class A {

	private int a;
	private double b;
	private boolean c;
	
	public A(int a1, int a2) {
		if(a1 > a2) {
			this.a = a1;
		}else {
			this.a = a2;
		}
		System.out.println(a);
	}
	
	public A(double b1, double b2, double b3) {
		this.b = b1 * b2 * b3;
		System.out.println(b);
	}
	
	public A(String c1, String c2) {
		if(c1.equals(c2)) {
			this.c = true;
		}else {
			this.c = false;
		}
		System.out.println(c);
	}
	
	
	
	
}
