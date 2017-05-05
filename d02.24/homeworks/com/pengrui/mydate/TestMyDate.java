package com.pengrui.mydate;

public class TestMyDate {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(2017,1,1);
		System.out.println(date1.toString());
		System.out.println("前一天：" + date1.previousDay());
		System.out.println("后一天：" + date1.nextDay());
		System.out.println("前一个月：" + date1.previousMonth());
		System.out.println("后一个月：" + date1.nextMonth());
		System.out.println("前一年：" + date1.previousYear());
		System.out.println("后一年：" + date1.nextYear());
		System.out.println("错误输入测试：");
		MyDate date2 = new MyDate(2017, 2, 29);
		date2.setYear(0);
		date2.setMonth(13);
	}
}
