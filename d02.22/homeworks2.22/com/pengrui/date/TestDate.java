package com.pengrui.date;

public class TestDate {
	
	public static void main(String[] args) {
		
		Date d1 = new Date(22, 2, 2017);
		System.out.println(d1.toString());
		
		d1.setDate(1, 1, 2017);
		System.out.println(d1.toString());
		
		d1.setDay(4);
		d1.setMonth(11);
		d1.setYear(1992);
		System.out.println(d1.toString());
		
		Date d2 = (Date) d1.clone();
		System.out.println("克隆体：" + d2.toString());
		System.out.println("本体哈希码值：" + d1.hashCode());
		System.out.println("克隆体哈希码值：" + d2.hashCode());
		System.out.println(d1.equals(d2));
	}

}
