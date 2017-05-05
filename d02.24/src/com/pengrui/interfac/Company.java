package com.pengrui.interfac;

public class Company implements EnvStandard{

	public void clean() {
		System.out.println("Company调用了clean()");
	}
	
	public void recycle() {
		System.out.println("Company调用了recycle()");
	}
}
