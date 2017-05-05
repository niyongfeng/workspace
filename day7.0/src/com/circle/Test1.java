package com.circle;

public class Test1 {
	
	public static void main(String[] args){
		Person p = new Son1();
		p.print();
		System.out.println(p.a);
	}

}

class Person {
	int a = 1;
	public void print() {
		print2();
		System.out.println("Person print的方法");
	}
	
	public void print2() {
		System.out.println("Person print2的方法");
	}
}
class Son extends Person {
	int a = 2;
//	public void print() {
//		super.print();
//		System.out.println("Son print的方法");
//	}
	
	public void print2() {
		System.out.println("Son print2的方法");
	}
} 

class Son1 extends Son {
	int a = 3;
	public void print() {
		super.print();
		System.out.println("Son1 print的方法");
	}
	
	public void print2() {
		System.out.println("Son1 print2的方法");
	}
	
}
