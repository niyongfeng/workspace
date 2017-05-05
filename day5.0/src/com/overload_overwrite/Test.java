package com.overload_overwrite;

public class Test {

	public static void main(String[] agres) {
		
		Father father = new Father();
		Son son = new Son();
		System.out.println(father.toString());
		System.out.println(son.toString());
	}
}
