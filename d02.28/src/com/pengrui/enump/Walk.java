package com.pengrui.enump;

public class Walk {
	public void go(Light light) {
		switch(light) {
		case RED : System.out.println("红灯停！" + light.getL());break;
		case GREEN : System.out.println("绿灯行！" + light.getL());break;
		case YELLOW : System.out.println("黄灯注意！" + light.getL());break;
		}
	}
	
	public static void main(String[] args) {
		Walk walk = new Walk();
		walk.go(Light.RED);
		walk.go(Light.GREEN);
		walk.go(Light.YELLOW);
	}
}
