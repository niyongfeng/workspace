package com.testpaper;

public class WuMingFen {
	
	private String theMa = "酸辣";
	private int quantity = 2;
	private boolean likeSoup = true;
	
	public WuMingFen(String theMa, int quantity, boolean likeSoup) {
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}
	
	public WuMingFen(String theMa, int quantity) {
		this.theMa = theMa;
		this.quantity = quantity;
	}
	
	public WuMingFen() {
		
	}

	public String check() {
		return "WuMingFen : theMa = " + theMa + ", quantity = " + quantity + ", likeSoup = " + likeSoup; 
	}
}
