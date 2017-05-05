package com.pengrui.test4;

public class Calculator {
	private int n1;
	private int n2;
	
	public Calculator() {
		
	}
	
	public Calculator(int n1, int n2) {
		this.n1 = n1;
		this.n2 = n2;
	}
	
	public void addition() {
		System.out.println("n1 + n2 =" + (n1 + n2));
	}
	
	public void subtration() {
		System.out.println("n1 - n2 =" + (n1 - n2));
	}
	
	public void multiplication() {
		System.out.println("n1 * n2 = " + n1 * n2);
	}
	
	public void division() {
		if(n2 == 0) {
			System.out.println("除数不能为0");
		}else {
			System.out.println("n1 / n2 = " + n1 / n2);
		}
	}
	
	public static void main(String[] args) {
		Calculator c = new Calculator(1, 2);
		c.addition();
		c.subtration();
		c.multiplication();
		c.division();
	}
}


