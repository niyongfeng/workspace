package com.project;

public abstract class Airplane {
	
	private String model;
	private int price;
	private String application;
	
	public Airplane() {
		
	}
	
	public Airplane(String model, int price, String application) {
		this.model = model;
		this.price = price;
		this.application = application;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getApplication() {
		return application;
	}
	
	public abstract String toString();

}
