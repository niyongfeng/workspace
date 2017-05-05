package com.project3;

public class Text {

	public static void main(String[] agrs) {
		
		GateDoor gatedoor = new GateDoor();
		RoomDoor roomdoor = new RoomDoor();
		SafeDoor safedoor = new SafeDoor();
		
		System.out.println(gatedoor.toString());
		System.out.println(roomdoor.toString());
		System.out.println(safedoor.toString());
		System.out.println("");
		
		System.out.println("打开所有门：");
		System.out.println("大门：" + gatedoor.openDoor());
		System.out.println("房间门：" + roomdoor.openDoor());
		System.out.println("保险柜门:" + safedoor.openDoor());
		System.out.println("");
		
		System.out.println("关闭所有门");
		System.out.println("大门：" + gatedoor.closeDoor());
		System.out.println("房间门：" + roomdoor.closeDoor());
		System.out.println("保险柜门：" + safedoor.closeDoor());
	}
}
