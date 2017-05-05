package com.pengrui.trafficlight;

public class Walk {
	
	public void go(TrafficLight l) {
		
		System.out.println(l.getLight());
		switch(l) {
		case RED : System.out.println("红灯停！");break;
		case GREEN : System.out.println("绿灯行！");break;
		case YELLOW : System.out.println("黄灯注意！");break;
		}
	}
	
	public static void main(String[] args) {
		Walk walk = new Walk();
		walk.go(TrafficLight.GREEN);
		walk.go(TrafficLight.RED);
		walk.go(TrafficLight.YELLOW);
	}
}
