package com.test2;

public class Test6 {

	public static void main(String[] args) {
		Phone p = new Phone();
		Phone p1 = new Phone("iphone", 4888);
		
		System.out.println(p1.toString());
		System.out.println(p.call());
		System.out.println(p.sendMessage());
		System.out.println(p.playGame());
	}
}
