package com.pengrui.mydate;

public class MyDate {
	private int year = 1;
	private int month = 1;
	private int day = 1;
	private String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
									"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", 
									"Thursday", "Friday", "Saturday"};
	private int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	//判断是否是闰年；如果年份是100的倍数时，满足是400的倍数才是闰年；若果不是100的倍数
	public boolean isLeapYear(int year) {
		if(year % 100 == 0) {
			if(year % 400 == 0) {
				return true;
			}else {
				return false;
			}
		}else {
			if(year % 4 == 0) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	public boolean isValidDate(int year, int month, int day) {
		if(isLeapYear(year) == true) {
			daysInMonths[1] = 29;
		}
		if(year >= 1 && year < 10000) {
			if(month > 0 && month <= 12) {
					if(day > 0 && day <= daysInMonths[month - 1]) {
						return true;
					}else {
						System.out.println("你输入日子有误！");
						return false;
					}	
			}else {
				System.out.println("你输入的月份有误！");
				return false;
			}
		}else {
			System.out.println("你输入的年份有误！");
			return false;
		}
	}
	
	public int getDayOfWeek(int year, int month, int day) {
		int days = 0;
		if(isLeapYear(year) == true) {
			daysInMonths[1] = 29;
		}
		for(int i = 1; i < month; i++) {
			days = days + daysInMonths[i - 1];
		}
		days = (days + (int)((year - 1) * 365.25) + day - 1) % 7;
		return days;
	}
	
	public MyDate() {
		
	}
	
	public MyDate(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	public int getYear() {
		return year;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getDay() {
		return day;
	}
	
	public void setYear(int year) {
		if(isValidDate(year, month, day) == true) {
			this.year = year;
		}
	}
	
	public void setMonth(int month) {
		if(isValidDate(year, month, day) == true) {
			this.month = month;
		}
	}
	
	public void setDay(int day) {
		if(isValidDate(year, month, day) == true) {
			this.day = day;
		}	
	}
	
	public String toString() {
		return strDays[getDayOfWeek(year, month, day)] + " " + getDay() + " " + strMonths[month - 1] + " " + getYear();
	}
	
	public MyDate nextDay() {
		if(day == daysInMonths[month - 1]) {
			if(month == 12) {
				year = year + 1;
				month = 1;
			}else {
				month = month + 1;
			}
			day = 1;
		}else {
			day = day + 1;
		}
		return this;
	}
	
	public MyDate nextMonth() {
		if(month == 12) {
			year = year + 1;
			month = 1;
		}else {
			month = month + 1;
		}
		return this;
	}
	
	public MyDate nextYear() {
		year = year + 1;
		return this;
	}
	
	public MyDate previousDay() {
		if(isLeapYear(year) == true) {
			daysInMonths[1] = 29;
		}
		if(day == 1) {
			if(month == 1) {
				year = year - 1;
				month = 12;
			}else {
				month = month - 1;
			}
			day = daysInMonths[month - 1];
		}else {
			day = day - 1;
		}
		return this;
	}
	
	public MyDate previousMonth() {
		if(month == 1) {
			year = year - 1;
			month = 12;
		}else {
			month = month - 1;
		}
		return this;
	}
	
	public MyDate previousYear() {
		year = year - 1;
		return this;
	}

}
