package com.duotai;

public class Test {
	public static void main(String[] args) {
		Person p = new Son();
		//Son p1 = new Son1();
		//p1.print();
		p.print();
		
		//System.out.println(p1.i);
		//System.out.println(p.i);
	}
}
class Person {
	public Person() {
		System.out.println("gggg");
	}
	int i = 0;
	public void print() {
		print2();
		System.out.println("123");
	}
	
	public void print2() {
		System.out.println("456");
	}
}

class Son extends Person{
	
	
	public Son() {
		//super();
		System.out.println("////");
	}
	
	public Son(int i) {
		//super();
		this.i = i;
	}
	int i = 1;
	public void print2() {
		System.out.println("789");
	}
	
	public void d(){
		System.out.println("kkkkk");
	}
}

class Son1 extends Son{
	int i = 2;
	public Son1() {
		System.out.println("mmmmm");
	}
	public void print() {
		super.print();
		System.out.println("10,11,12");
	}
	
	public void print2() {
		System.out.println("13,14,15");
	}
}