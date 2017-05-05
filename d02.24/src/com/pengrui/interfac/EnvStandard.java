package com.pengrui.interfac;

public interface EnvStandard {
	
	public abstract void clean();
	
	public abstract void recycle();
	
	//静态修饰的方法
	public static void sys() {
		System.out.println("我自己的方法");
	}
	
	//default 修饰的方法可以被重写，补充些调用时就调用接口默认的
	public default String eql() {
		return "EnvStandard的eql";
	}
	
}
