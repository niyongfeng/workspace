package com.pengrui.enums;

enum Dog {
	JINMAO("金毛"),TAIDI("泰迪"),ERHA("二哈");
	
	public String chineseName;
	private Dog(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public String dogName() {
		return chineseName + "_" + this.name();
	}
}

public class MyDog {

	public void getDog(Dog dog) {
		System.out.println(dog.dogName());
		
		switch(dog) {
		case JINMAO : System.out.println("金毛很乖！");break;
		case TAIDI : System.out.println("泰迪太色！");break;
		case ERHA : System.out.println("二哈很蠢！");break;
		}
	}
	
	public static void main(String[] args) {
		MyDog mydog = new MyDog();
		mydog.getDog(Dog.JINMAO);
		mydog.getDog(Dog.TAIDI);
		mydog.getDog(Dog.ERHA);
	}
}
