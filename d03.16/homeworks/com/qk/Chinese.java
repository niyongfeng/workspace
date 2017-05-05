package com.qk;

public class Chinese extends Person implements Fightable{
	
	public Chinese() {
		
	}
	
	public Chinese(String name, int age) {
		super(name, age);
	}
	
	public void fight() {
		System.out.println("中国人会太极!");
	}
	
	public void pingpang() {
		System.out.println("中国人乒乓球世界第一!");
	}
}
