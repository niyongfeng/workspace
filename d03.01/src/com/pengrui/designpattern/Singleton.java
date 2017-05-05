package com.pengrui.designpattern;

public class Singleton {
	private int count = 0;
	private Singleton() {
		
	}
	public void daka() {
		count = count + 1;
	}
	//1.饿汉模式：
	private static final Singleton singleton1 = new Singleton();
	
	public static Singleton getInstance1() {
		return singleton1;
	}
	
	//2.懒汉模式：
	private static Singleton singleton2 = null;
	
	public static Singleton getInstance2() {
		if(singleton2 == null) {
			singleton2 = new Singleton();
		}
		return singleton2;
	}

}
