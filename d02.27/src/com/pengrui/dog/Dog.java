package com.pengrui.dog;

interface Food {
	public void beEat();
}

public class Dog {
	
	private String name;
	private double height;
	private DogHouse dogHouse;
	
	public Dog() {
		
	}
	
	public Dog(String name, double height) {
		this.name = name;
		this.height = height;
		dogHouse = new DogHouse();
		dogHouse.setDogHouse(height);
	}
//  1.内部类	
	public class DogHouse{
		
		public void setDogHouse(double height) {
			System.out.println("构建一个高度为:" + height + "的狗窝!");
		}
		
	}
	
	public void eat(Food food) {
		food.beEat();
	}
//  2.方法内部类
	public void run() {
		System.out.println(name + "开始跑步了！");
		class DogShoes {
			public DogShoes() {
				System.out.println("开始加速了！");
			}
		}
		DogShoes d = new DogShoes();
		System.out.println(name + "跑完了！");
	}
	
	public void print() {
		System.out.println("My name is " + name + "!");
		System.out.println("My height is " + height + "!");
		System.out.println("I hava a doghouse!");
	}
	
	public static void main(String[] args) {
		Dog dog = new Dog("旺财", 50);
		dog.print();
		Dog.DogHouse dh = new Dog().new DogHouse();
		dh.setDogHouse(60);
		dog.run();
		
//		3.匿名内部类写法1：
		dog.eat(new Food() {
			public void beEat() {
				System.out.println("我被吃了！");
			}
		});
//		3.匿名内部类写法2：
		Food food = new Food() {
			public void beEat() {
				System.out.println("吃完了！");
			}
		};
		dog.eat(food);
		
		Dog.DogStat d1 = new Dog.DogStat();
		
	}
	
//	4.静态内部类
	public static class DogStat{
		public DogStat() {
			System.out.println("好多条");
		}
	}

}
