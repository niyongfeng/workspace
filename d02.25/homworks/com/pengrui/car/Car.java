package com.pengrui.car;

public class Car extends Auto implements Cloneable{
	private boolean air;
	private boolean cd;
	
	public Car() {
		
	}
	
	public Car(boolean air, boolean cd) {
		this.air = air;
		this.cd = cd;
	}
	
	public Car(Auto auto, boolean air, boolean cd) {
		super(auto.getBype(), auto.getColor(), auto.getWeight(), auto.getSpeed());
		this.air = air;
		this.cd = cd;
	}

	public boolean isAir() {
		return air;
	}

	public void setAir(boolean air) {
		this.air = air;
	}

	public boolean isCd() {
		return cd;
	}

	public void setCd(boolean cd) {
		this.cd = cd;
	}
	
	public void speedUp(double up) {
		super.setSpeed(super.getSpeed() + 2 * up);
	}
	
	public void speedDown(double down) {
		super.setSpeed(super.getSpeed() - 2 * down);
	}
	
	public String toString() {
		return super.toString() + ", Air:" + isAir() + ",Cd:" + isCd();
	}
	public static void main(String[] args) {
		Car c = new Car();
		try {
			Car c1 = (Car)c.clone();
			System.out.println(c1.toString());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

