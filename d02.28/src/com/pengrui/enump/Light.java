package com.pengrui.enump;

public enum Light {
	RED("红灯"),GREEN("绿灯"),YELLOW("黄灯");
	
	public String chinese;
	private Light(String chinese) {
		this.chinese = chinese;
	}
	
	public String getL() {
		return chinese + ":" + this.name();
	}
}
