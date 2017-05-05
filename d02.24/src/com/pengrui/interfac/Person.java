package com.pengrui.interfac;

public class Person implements EnvStandard{

	public void clean() {
		System.out.println("Person调用了clean()");
	}
	
	public void recycle() {
		System.out.println("Person调用了recycle()");
	}
}
