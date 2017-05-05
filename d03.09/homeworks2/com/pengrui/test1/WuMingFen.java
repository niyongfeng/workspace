package com.pengrui.test1;

public class WuMingFen {
	private String theMa = "酸辣";
	private int quantity = 2;
	private boolean likeSoup = true;
	
	public WuMingFen() {
		
	}
	
	public WuMingFen(String theMa, int quantity, boolean likeSoup) {
		this.theMa = theMa;
		this.quantity = quantity;
		this.likeSoup = likeSoup;
	}
	
	public WuMingFen(String theMa, int quantity) {
		this.theMa = theMa;
		this.quantity = quantity;
	}
	
	public void check() {
		String str = "";
		if(likeSoup) {
			str = "带汤的";
		}else {
			str = "不带汤的";
		}
		System.out.println(theMa + "面码," + quantity + "两," + str);
	}
	
	public static void main(String[] args) {
		WuMingFen f1 = new WuMingFen("牛肉", 3, true);
		f1.check();
		WuMingFen f2 = new WuMingFen("牛肉", 2);
		f2.check();
		WuMingFen f3 = new WuMingFen();
		f3.check();
	}
}
