package com.pengtui.mytime;

public class TestMyTime {

	public static void main(String[] args) {
		MyTime t1 = new MyTime(0, 0, 0);
		System.out.println(t1.toString());
		System.out.println("前一秒：" + t1.previousSecond());
		System.out.println("后一秒：" + t1.nextSecond());
		System.out.println("前一分钟：" + t1.previousMinute());
		System.out.println("后一分钟：" + t1.nextMinute());
		System.out.println("前一小时：" + t1.previousHour());
		System.out.println("后一小时：" + t1.nextHour());
		
		System.out.println("以下测试是不符合时间数值的情况：");
		t1.setHour(27);
		t1.setMinute(88);
		t1.setSecond(60);
		MyTime t2 = new MyTime(60,70,80);
		System.out.println(t2.toString());
	}
}
