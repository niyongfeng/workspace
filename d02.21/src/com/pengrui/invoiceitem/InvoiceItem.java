package com.pengrui.invoiceitem;

public class InvoiceItem {
	
	private String id = "110";
	private String desc = "浙江传媒学院";
	private int qty = 1;
	private double unitPrice = 666;
	
	public InvoiceItem() {
		
	}
	
	public InvoiceItem(String id, String desc, int qty, double unitPrice) {
		this.id = id;
		this.desc = desc;
		this.qty = qty;
		this.unitPrice = unitPrice;
	}
	
	public String getId() {
		return id;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getTotal() {
		return unitPrice * qty;
	}
	
	public String toString() {
		return "InvoiceItem [ id = " + id + ", desc = " + desc + ", qty = " + 
				qty + ", unitPrice = " + unitPrice + " ]";
	}

}
