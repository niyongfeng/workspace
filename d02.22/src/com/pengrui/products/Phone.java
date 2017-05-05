package com.pengrui.products;

public class Phone {
	
	private String model;
	private String brand;
	private int price;
	
	public Phone() {
		
	}
	
	public Phone(String model, String brand, int price) {
		this.model = model;
		this.brand = brand;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getBrand() {
		return brand;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString() {
		return "model: " + model + ", brand: " + brand + ", price:" + price; 
	}
}
