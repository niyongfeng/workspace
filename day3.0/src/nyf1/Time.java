package nyf1;

public class Time {
	private int hour = 0;
	private int minute = 0;
	private int second = 0;
	
	public Time(int hour, int minute, int second){
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
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	public void setSecond(int second) {
		this.second = second;
	}
	
	public void setTime(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public String toString() {
		String str = "";
		if(hour < 10) {
			str = "0" + hour;
		}else if(hour == 24) {
			str = "00";
		}else {
			str = "" + hour;
		}
		if(minute < 10) {
			str = str + ":0" + minute;
		}else {
			str = str + ':' + minute;
		}
		if(second < 10) {
			str = str + ":0" + second;
		}else {
			str = str + ':' + second;
		}
		return str;
	}
	
	public Time nextSecond() {
		if(second >= 0 && second < 59) {
			second = second + 1;
		}else {
			if(minute >= 0 && minute < 59) {
				minute = minute + 1;
				second = 0;
			}else {
				second = 0;
				minute = 0;
				hour = hour + 1;
			}
		}
		return this;
				//new Time(hour,minute,second);
		
	}
	
	public Time previousSecond() {
		if(second > 0 && second <= 59) {
			second = second - 1;
		}else {
			if(minute > 0 && minute <= 59) {
				minute = minute - 1;
				second = 59;
			}else {
				second = 59;
				minute = 59;
				hour = hour - 1;
			}
		}
		return this;
				//new Time(hour,minute,second);
	}
}
