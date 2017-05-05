package com.pengrui.door;

public class Test {
	public static void main(String[] args) {
		RoomDoor r = new RoomDoor();
		GateDoor g = new GateDoor();
		
		r.print();
		g.print();
		g.openDoor();
		r.openDoor();
		r.closeDoor();
		g.closeDoor();
		
	}

}
