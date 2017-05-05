package com.pengrui.door;

public class RoomDoor extends Door implements Waterproof, Fireproof, Rustproof{
	public RoomDoor() {
		
	}
	
	public void fireProof() {
		System.out.println("高级防火功能！");
	}
	
	public void openDoor() {
		System.out.println("RoomDoor已开！");
	}
	
	public void closeDoor() {
		System.out.println("RoomDoor已关！");
	}
	
	public void print() {
		System.out.println("RoomDoor有：");
		Waterproof.waterProof();
		Rustproof.rustProof();
		this.fireProof();
	}

}
