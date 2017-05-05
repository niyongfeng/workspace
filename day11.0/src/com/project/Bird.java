package com.project;

public abstract class Bird {
	
	private String color;
	private String kind;
	private boolean eat;
	
	public Bird() {
		
	}
	
	public Bird(String color, String kind, boolean eat) {
		this.color = color;
		this.kind = kind;
		this.eat = eat;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void setEat(boolean eat) {
		this.eat = eat;
	}
	
	public String getColor() {
		return color;
	}
	
	public String getKind() {
		return kind;
	}
	
	public boolean getEat() {
		return eat;
	}
	
	public abstract String toString();

}
