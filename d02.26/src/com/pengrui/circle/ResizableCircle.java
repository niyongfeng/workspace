package com.pengrui.circle;

public class ResizableCircle extends Circle implements Resizable{
	
	public ResizableCircle(double radius) {
		super(radius);
	}
	
	public void resize(int percent) {
		radius = radius * percent / 100;
	}
}
