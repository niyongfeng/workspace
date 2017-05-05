package com.pengrui.car;

public class Test {
	public static void main(String[] args) {
		Auto auto = new Auto(4, "red", 100, 50);
		System.out.println(auto.toString());
		auto.speedUp(10);
		System.out.println("加速后：" + auto.toString());
		auto.speedDown(20);
		System.out.println("减速后：" + auto.toString());
		Car car = new Car(auto, true, true);
		System.out.println(car.toString());
		car.speedUp(10);
		System.out.println("加速后：" + car.toString());
		car.speedDown(20);
		System.out.println("减速后：" + car.toString());
	}
	
}
