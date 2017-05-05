package com.pengrui.test;
import com.pengrui.animals.Dog;
import com.pengrui.people.Person;
import com.pengrui.products.Phone;;

public class Test {
	public static void main(String[] args) {
		Person p1 = new Person("niyongfeng", 26, "330621199211041534");
		Dog dog1 = new Dog("啊", "宝", 2, "金毛");
		Dog dog2 = new Dog("啊", "毛", 1, "泰迪");
		p1.dogs = new Dog[]{dog1,dog2};
		Phone phone1 = new Phone("iphone", "6s", 4888);
		Phone phone2 = new Phone("iphone", "7Plus", 6888);
		p1.phones = new Phone[]{phone1, phone2};
		System.out.println(p1.toString());
		System.out.println("");
		
		Person p2 = new Person("nyf", 18, "123456789012345678");
		p2.dogs = new Dog[]{new Dog("大", "黄", 2, "土狗")};
		p2.phones = new Phone[]{new Phone("华为", "荣耀7", 4888)};
		System.out.println(p2.toString());
		
		Person p3 = new Person("xxx", 99, "098765432109876543");
		System.out.println(p3.toString());
	}

}
