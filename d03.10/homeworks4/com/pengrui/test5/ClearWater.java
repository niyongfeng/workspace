package com.pengrui.test5;

public class ClearWater extends Water implements Buffer,Warm,Sugar,Filter{
	
	public void water() {
		print();
		Buffer.print1();
		Warm.print2();
		print3();
		
	}

	public void print3() {
		System.out.println("加糖！");
	}
	
	public static void main(String[] args) {
		ClearWater c = new ClearWater();
		c.water();
		
	}
}
