package com.pengrui.interfacevehicle;

public class Bike implements Vehicle{
	public void start() {
		System.out.println("Bike 已启动！");
	}
	
	public void stop() {
		System.out.println("Bike 已停止！");
	}
}
