package com.pengrui.test3;

public class MyTime {
	private int hour;
	private int minute;
	private int second;
	
	public MyTime() {
		
	}
	
	public MyTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public int getHour() {
		return hour;
	}
	
	public int getMinute() {
		return minute;
	}
	
	public int getSecond() {
		return second;
	}
	
	public String display() {
		return "时间为：" + getHour() + ":" + getMinute() + ":" + getSecond();
	} 
	
	public void addSecond(int sec) {
		second = second + sec;
		if(second >= 60) {
			if(minute == 59) {
				if(hour == 23) {
					hour = 0;
				}else {
					hour++;
				}
				minute = 0;
			}else {
				minute++;
			}
			second = second - 60;
		}
	}
	
	public void addMinute(int min) {
		minute = minute + min;
		if(minute >= 60) {
			minute = minute - 60;
			if(hour == 23) {
				hour = 0;
			}else {
				hour++;
			}
		}
	}
	
	public void addHour(int hou) {
		hour = hour + hou;
		if(hour >= 24) {
			hour = hour - 24;
		}
	}
	
	public void subSecond(int sec) {
		second = second - sec;
		if(second < 0) {
			if(minute == 0) {
				minute = 59;
				if(hour == 0) {
					hour = 23;
					System.out.println("前一天的时间");
				}else {
					hour--;
				}
			}else {
				minute--;
			}
			second = second + 60;
		}
	}
	
	public void subMinute(int min) {
		minute = minute - min;
		if(minute < 0) {
			if(hour == 0) {
				hour = 23;
				System.out.println("前一天的时间");
			}else {
				hour--;
			}
			minute = minute + 60;
		}
	}
	
	public void subHour(int hou) {
		hour = hour - hou;
		if(hour < 0) {
			hour = hour + 24;
			System.out.println("前一天的时间");
		}
	}
	
	public static void main(String[] args) {
		MyTime t1 = new MyTime(23,59,59);
		t1.addSecond(1);
		System.out.println(t1.display());
		t1.subSecond(1);
		System.out.println(t1.display());
		t1.addMinute(1);
		System.out.println(t1.display());
		t1.subMinute(1);
		System.out.println(t1.display());
		t1.addHour(1);
		System.out.println(t1.display());
		t1.subHour(1);
		System.out.println(t1.display());
	}
}
