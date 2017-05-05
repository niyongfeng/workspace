package com.testpaper;

public class TestVehicles {

	public static void main(String[] args) {
		Car car = new Car("兰博基尼", "黄色", 2);
		Truck truck = new Truck("三菱", "黄色", 5.0f);
		
		System.out.println(car.showCar());
		System.out.println(truck.showTruck());
	}
}
