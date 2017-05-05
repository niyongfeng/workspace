package com.project1;

public class Test {
	public static void main(String[] args) {
		A a = new A();
		A.B b = new A().new B();
		A.C c = new A.C();
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(c.toString());
		System.out.println(a.to());
		
		
	}

}
