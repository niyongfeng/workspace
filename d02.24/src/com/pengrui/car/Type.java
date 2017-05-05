package com.pengrui.car;

public class Type {
	private int quantity;
	
	public Type() {
		
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public Type(int quantity) {
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		return "安装" + quantity + "个轮胎.";
	}
	
}
