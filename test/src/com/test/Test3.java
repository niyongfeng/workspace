package com.test;

public class Test3 {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 1000; i++) {
			while(i % 40 == 0) {
				System.out.println(i);
				break;
			}
		}
		
	}
}
