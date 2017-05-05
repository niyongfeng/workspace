package com.pengrui.interfac;

public class College implements EnvStandard{
	public void clean() {
		System.out.println("College调用了clean()");
	}
	
	public void recycle() {
		System.out.println("College调用了recycle()");
	}
}
