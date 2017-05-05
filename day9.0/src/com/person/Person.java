package com.person;

public enum Person {

	MAN("男人"), WOMAN("女人");
	
	public String sc;
	
	private Person(String sc) {
		this.sc = sc;
	}
	
	public String toString() {
		return sc;
	}
}
