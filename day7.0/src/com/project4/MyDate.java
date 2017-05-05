package com.project4;

public class MyDate {
	
	private int year;
	private int month;
	private int day;
	private String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", 
			"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	private String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday"};
	int[] dayInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public MyDate() {
		
	}
	
	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && year / 100 != 0 || year / 400 == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValidDate(int year, int month, int day) {
		if(year >= 1 && year <= 9999) {
			if(month >=1 && month <= 12) {
				if(month == 4 || month == 6 || month == 9 || month == 11) {
					if(day >=1 && day <= 30) {
						return true;
					}else {
						return false;
					}
				} else if (month == 2) {
					if(isLeapYear(year) == true && day >=1 && day <= 29) {
						return true;
					}else if(isLeapYear(year) == false && day >= 1 && day <=28){
						return true;
					}else {
						return false;
					}
				}else {
					if(day >= 1 && day <= 31) {
						return true;
					}else {
						return false;
					}
				}
				
			} else {
				return false;
			}
			
		}else {
			return false;
		}
	}
	
	public int getDayOfWeek(int year, int month, int day) {
		int x = 0;
		int days = 0;
		if(isLeapYear(year) == false) {
			for(int i = 0; i < month - 1; i++) {
				x = dayInMonths[i] + x;
			}
		}else {
			dayInMonths[1] = 29;
			for(int i = 0; i < month - 1; i++) {
				x = x + dayInMonths[i];
			}
		}
		days =(int) (365.25 * (year - 1) + (day - 1) + x) % 7;
		return days;
	}
	
	public MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void setDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
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
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public String toString() {
		return strDays[getDayOfWeek(year, month, day)] + " " + day + " " + strMonths[month - 1] + " " + year;
	}
	
	public MyDate nextDay() {
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			if(day < 30) {
				day = day + 1;
			}else {
				day = 1;
				month = month + 1;
			}
			
		}else if(month == 2) {
			if(isLeapYear(year) == true) {
				if(day < 28) {
					day = day + 1;
				}else {
					day = 1;
					month = month + 1;
				}
			}
		}else if(month == 12) {
			if(day < 31) {
				day = day + 1;
			}else {
				day = 1;
				month = 1;
				year = year + 1;
			}
		}else {
			if(day < 31) {
				day = day + 1;
			}else {
				day = 1;
				month = month + 1;
			}
		}
		return this;
	}
	
	public MyDate nextMonth() {
		if(month < 12) {
			month = month + 1;
		}else {
			month = 1;
			year = year + 1;
		}
		return this;
	}
	
	public MyDate nextYear() {
		year = year + 1;
		return this;
	}
	
	public MyDate previousDay() {
		if(day == 1) {
			if(month == 1) {
				year = year - 1;
				month = 12;
				day = 31;
			}else if(month == 5 || month == 7 || month == 10 || month == 12) {
				month = month - 1;
				day = 30;
			}else {
				month = month - 1;
				day = 31;
			}
		}else {
			day = day - 1;
		}
		return this;
	}
	
	public MyDate previousMonth() {
		if(month == 1) {
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
