package com.pengrui.enums;

enum Gender {
	MAN("男"),WOMAN("女");
	public String cN;
	private Gender(String cN) {
		this.cN = cN;
	}

}

public class MyGender {
	public void getGender(Gender gender) {
		System.out.println(gender.cN + "_" + gender.name());
		switch(gender) {
		case MAN : System.out.println("男人力气大！");break;
		case WOMAN : System.out.println("女人比较细心！");break;
		}
	}

	public static void main(String[] args) {
		MyGender m = new MyGender();
		m.getGender(Gender.MAN);
		m.getGender(Gender.WOMAN);
	}
}

