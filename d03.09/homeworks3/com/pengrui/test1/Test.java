package com.pengrui.test1;

class Test1 {
	public static int a = 10;
	public int b = 5;
	
	public Test1() {
		
	}
	
	
}

public class Test {
	public static void main(String[] args) {
		System.out.println(Test1.a);
		Test1 s = new Test1();
		System.out.println(s.b);
	}
}