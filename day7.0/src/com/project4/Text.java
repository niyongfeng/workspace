package com.project4;

public class Text {

	public static void main(String[] args) {
		MyDate mydate = new MyDate(2017, 12, 31);
		System.out.println("初始日期：" + mydate.toString());
		System.out.println("明天：" + mydate.nextDay());
		System.out.println("下个月：" + mydate.nextMonth());
		System.out.println("明年：" + mydate.nextYear());
		System.out.println("");
		System.out.println("昨天：" + mydate.previousDay());
		System.out.println("上个月：" + mydate.previousMonth());
		System.out.println("去年：" + mydate.previousYear());
	}
}
