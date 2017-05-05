package com.pengrui.door;

public interface Bulletproof {
	public default void bulletProof() {
		System.out.println("防弹功能！");
	}
}
