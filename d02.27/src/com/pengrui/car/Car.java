package com.pengrui.car;

public class Car {
	private String model;
	private String brand;
	private int power;
	public class Battery {
		//private int power = 1000;
		
		public int userPower() {
			power = power - 100;
			if(power >= 100 && power < 300) {
				return 0;
			}else if(power >= 300) {
				return 1;
			}else {
				return -1;
			}
		}
		
		public void charge() {
			power = 1000;
		}
	}
	Battery c = new Battery();
	public void start() {
		c.userPower();
		if(power < 100) {
			System.out.println("请立即充电！");
			c.charge();
			System.out.println("充电完成，当前电量：" + power);
		}else {
			System.out.println("当前电量：" + power);
		}
	}
	
	public Car() {
		power = 1000;
	}
	
	public Car(String model, String brand) {
		this.model = model;
		this.brand = brand;
		power = 1000;
		
	}
	
	public String toString() {
		return "Car(Model:" + model + ",Brand:" + brand + ")";
	}
	
}
