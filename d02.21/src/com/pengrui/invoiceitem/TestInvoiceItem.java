package com.pengrui.invoiceitem;


public class TestInvoiceItem {
	
	public static void main(String[] args) {
		InvoiceItem t1 = new InvoiceItem();
		System.out.println(t1.toString());
		System.out.println("Total = " + t1.getTotal());
		t1.setQty(5);
		t1.setUnitPrice(5000);
		System.out.println(t1.toString());
		System.out.println("Total = " + t1.getTotal());
		
		InvoiceItem t2 = new InvoiceItem("111", "君强科技有限公司", 2, 10000);
		System.out.println(t2.toString());
		System.out.println("Total = " + t2.getTotal());
		
	}

}
