package com.qingke.nyf;

public class Date implements Comparable{
	private int year;
	private int month;
	private int day;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Date)) {
			return 0;
		}
		Date date = (Date) o;
		if(date.year > this.year) {
			System.out.println(date);
			return 1;
		}else if(date.year < this.year) {
			System.out.println(this);
			return -1;
		}else {
			if(date.month > this.month) {
				System.out.println(date);
				return 1;
			}else if(date.month < this.month) {
				System.out.println(this);
				return -1;
			}else {
				if(date.day > this.day) {
					System.out.println(date);
					return 1;
				}else if(date.day < this.day) {
					System.out.println(this);
					return -1;
				}else {
					return 0;
				}
			}
		}
	}
	
	
}
