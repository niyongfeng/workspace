package com.test2;

public class Phone {

	private String brand;
	private int price;
	
	public Phone() {
		
	}
	
	public Phone(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}
	
	public String call() {
		return "打电话";
	}
	
	public String sendMessage() {
		return "发短信";
	}
	
	public String playGame() {
		return "打游戏";
	}
	
	public String toString() {
		return "Phone [ brand:" + brand + " , price:" + price + " ]";
	}
}
