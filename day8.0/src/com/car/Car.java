package com.car;

public class Car {

	private String brand;
	private String model;
	
	public Car(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	public class Battery {
		private int power = 1000;
		
		public int userPower() {
			power = power - 100;
			if(power <= 300 & power > 100) {
				System.out.println(power);
				return 0;
			}else if(power <= 100 && power > 0) {
				System.out.println(power);
				return -1;
			}else {
				System.out.println(power);
				return 1;
			}
			
		}
		
		public int charge() {
			return power = 1000;
		}
		
	}
	Battery battery = new Battery();
	public void start() {
////		Battery battery = new Battery();
		int x = battery.userPower(); 
		if(x == 1) {
			System.out.println("电量充足");
		}else if(x == 0){
			System.out.println("电量低");
		}else{
			System.out.println("电量不足，即将自动充电");
			battery.charge();
		}
//		if(battery.userPower() == -1) {
//			System.out.println("电量不足，即将自动充电");
//			battery.charge();
//		}else {
//			System.out.println( "电量够");
//		}
		
	}
	public String toString() {
		return "我的座驾：" + brand + model;
	}
	
}
