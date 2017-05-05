package com.project;

public class Pigeon extends Bird implements Fly{
	
	private String function;
	
	public Pigeon() {
		
	}
	
	public Pigeon(String function) {
		this.function = function;
	}
	
	public Pigeon(String color, String kind, boolean eat, String function) {
		super(color, kind, eat);
		this.function = function;
	}
	
	public void setFunction(String function) {
		this.function = function;
	}
	
	public String getFunction() {
		return function;
	}
	
	public String toFly() {
		return "Pigeon can fly";
	}
	
	public String toString() {
		return "Pigeon [ color:" + super.getColor() + ",kind:" + super.getKind() + ",eat:" + super.getEat()
			+ ",function:" + function + " ]";
	}

}
