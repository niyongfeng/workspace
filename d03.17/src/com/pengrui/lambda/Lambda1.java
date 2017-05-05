package com.pengrui.lambda;

public class Lambda1 {
	
	public static void main(String[] args) {
		for(int i = 0; i < 1000; i++) {
			new Thread(()->{System.out.println(Thread.currentThread().getId());}).start();
		}
		
	}
	
	public static void mmm(String str) {
		System.out.println(str);
	}

}
