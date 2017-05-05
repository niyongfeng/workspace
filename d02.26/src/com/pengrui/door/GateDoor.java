package com.pengrui.door;

public class GateDoor extends Door implements Theftproof, Waterproof, Bulletproof, Rustproof{
	public void openDoor() {
		System.out.println("GateDoor已开！");
	}
	
	public void closeDoor() {
		System.out.println("GateDoor已关！");
	}
	
	public void theftProof() {
		System.out.println("高级防盗功能！");
	}
	
	public void print() {
		System.out.println("GateDoor有：");
		this.theftProof();
		Waterproof.waterProof();
		this.bulletProof();
		Rustproof.rustProof();
	}
}
