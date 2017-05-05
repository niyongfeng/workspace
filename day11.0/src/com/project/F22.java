package com.project;

public class F22 extends Airplane implements Fly{
	
	private int ammunition;
	
	public F22() {
		
	}
	
	public F22(int ammunition) {
		this.ammunition = ammunition;
	}
	
	public F22(String model, int price, String application, int ammunition) {
		super(model, price, application);
		this.ammunition = ammunition;
	}
	
	public void setAmmunition(int ammunition) {
		this.ammunition = ammunition;
	}

	public int getAmmunition() {
		return ammunition;
	}
	
	public String toFly() {
		return "F22 can fly!";
	}
	
	public String toString() {
		return "F22 [ model:" + super.getModel() + ",price:" + super.getPrice() + ",application:" + super.getApplication()
			+ ",ammunition:" + ammunition + " ]";
	}
}
