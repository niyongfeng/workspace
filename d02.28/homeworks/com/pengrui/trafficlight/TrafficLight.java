package com.pengrui.trafficlight;

public enum TrafficLight {
	RED("红灯"),GREEN("绿灯"),YELLOW("黄灯");
	
	public String chineseLight;
	
	private TrafficLight(String chineseLight) {
		this.chineseLight = chineseLight;
	}
	
	public String getLight() {
		return chineseLight + ":" + this;
	}
}
