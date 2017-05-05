package com.pengrui.project;

// 创建一个生物的抽象类，任何生物都拥有身高，体重的属性；
/* 抽象类：1、成员变量：既可以是变量，也可以是常量
 * 		 2、构造函数：
 * 		 3、函数：可以抽象，也可以不是抽象；
 */
public abstract class Biology {
	
	public double height;
	public double weight;
	
	public Biology() {
		
	}
	
	public void print() {
		System.out.println("这是个生物类！");
	}
	
	public abstract void information();
}
