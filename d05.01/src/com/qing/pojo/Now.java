package com.qing.pojo;

public class Now {
	private String text;
	private int code;
	private int temperature;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	@Override
	public String toString() {
		return "Now [text=" + text + ", code=" + code + ", temperature=" + temperature + "]";
	}
	
	
}
