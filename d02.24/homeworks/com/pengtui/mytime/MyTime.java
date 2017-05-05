package com.pengtui.mytime;

public class MyTime {
	
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	public MyTime() {
		
	}
	
	public MyTime(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
	}
	
	public void setTime(int hour, int minute, int second) {
		setHour(hour);
		setMinute(minute);
		setSecond(second);
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
	
	public void setHour(int hour) {
		if(hour >= 0 && hour < 24) {
			this.hour = hour;
		}else {
			System.out.println("您的'小时'输入有误，请重新输入！");
		}
	}
	
	public void setMinute(int minute) {
		if(minute >= 0 && minute < 60) {
			this.minute = minute;
		}else {
			System.out.println("您的'分钟'输入有误，请重新输入！");
		}
	}
	
	public void setSecond(int second) {
		if(second >= 0 && second < 60) {
			this.second = second;
		}else {
			System.out.println("您的'秒数'输入有误，请重新输入！");
		}
	}
	
	public String toString() {
		String s, m, h;
		if(second >= 0 && second < 10) {
			s = "0" + second;
		}else {
			s = second + "";
		}
		
		if(minute >= 0 && minute < 10) {
			m = "0" + minute;
		}else {
			m = minute + "";
		}
		
		if(hour >= 0 && hour < 10) {
			h = "0" + hour;
		}else {
			h = hour + "";
		}
		return h + ":" + m + ":" + s;
	}
	
	public MyTime nextSecond() {
		if(second == 59) {
			if(minute == 59) {
				if(hour == 23) {
					hour = 0;
				}else {
					hour = hour + 1;
				}
				minute = 0;
				second = 0;
			}else {
				second = 0;
				minute = minute + 1;
			}
		}else {
			second = second + 1;
		}
		return this;
	}
	
	public MyTime nextMinute() {
		if(minute == 59) {
			if(hour == 23) {
				hour = 0;
			}else {
				hour = hour + 1;
			}
			minute = 0;
		}else {
			minute = minute + 1;
		}
		return this;
	}
	
	public MyTime nextHour() {
		if(hour == 23) {
			hour = 0;
		}else {
			hour = hour + 1;
		}
		return this;
	}
	
	public MyTime previousSecond() {
		if(second == 0) {
			if(minute == 0) {
				if(hour == 0) {
					hour = 23;
				}else {
					hour = hour - 1;
				}
				minute = 59;
				second = 59;
			}else {
				second = 59;
				minute = minute - 1;
			}
		}else {
			second = second - 1;
		}
		return this;
	}
	
	public MyTime previousMinute() {
		if(minute == 0) {
			if(hour == 0) {
				hour = 23;
			}else {
				hour = hour - 1;
			}
			minute = 59;
		}else {
			minute = minute - 1;
		}
		return this;
	}
	
	public MyTime previousHour() {
		if(hour == 0) {
			hour = 23;
		}else {
			hour = hour - 1;
		}
		return this;
	}

}
