package com.qing.pojo;

public class Daily {
	private String date;
	private String text_day;
	private String text_night;
	private int high;
	private int low;
	//private String precip;
	private double wind_speed;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText_day() {
        return text_day;
    }

    public void setText_day(String text_day) {
        this.text_day = text_day;
    }

    public String getText_night() {
        return text_night;
    }

    public void setText_night(String text_night) {
        this.text_night = text_night;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

//    public String getPrecip() {
//        return precip;
//    }
//
//    public void setPrecip(String precip) {
//        this.precip = precip;
//    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    @Override
    public String toString() {
        return "Daily{" +
                "date='" + date + '\'' +
                ", text_day='" + text_day + '\'' +
                ", text_night='" + text_night + '\'' +
                ", high=" + high +
                ", low=" + low +
               // ", precip=" + precip +
                ", wind_speed=" + wind_speed +
                '}';
    }
}
