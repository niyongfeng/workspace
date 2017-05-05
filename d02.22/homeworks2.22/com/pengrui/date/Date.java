package com.pengrui.date;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public String toString() {
		String day1 = "", month1 = "";
		if(day < 10) {
			day1 = "0" + day;
		}else {
			day1 = day + "";
		}
		if(month < 10) {
			month1 = "0" + month;
		}else {
			month1 = month + "";
		}
		return day1 + "/" + month1 + "/" + year;
	}
	
	public int hashCode() {
		String str = day + month + year + "";
		return str.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Date)) return false;
		
		Date date = (Date) obj;
		return date.day == day && date.month == month && date.year == year;
 	}
	
	public Object clone() {
		Date d = new Date(day, month, year);
		return d;
	}
}
