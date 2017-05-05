package com.enumproject;

public class Test {
	
	public static void main(String[] args) {
		Test test1 = new Test();
		System.out.println(TrafficLight.RED.toString());
		test1.go(TrafficLight.RED);
		System.out.println(TrafficLight.GREEN.toString());
		test1.go(TrafficLight.GREEN);
		System.out.println(TrafficLight.YELLOW.toString());
		test1.go(TrafficLight.YELLOW);
		
		System.out.println(TrafficLight.RED);
	}
	
	public void go(TrafficLight color) {
		if(color == TrafficLight.RED) {
			System.out.println("红灯停!");
		}else if(color == TrafficLight.YELLOW){
			System.out.println("黄灯慢!");
		}else {
			System.out.println("绿灯行!");
		}
	}

}
