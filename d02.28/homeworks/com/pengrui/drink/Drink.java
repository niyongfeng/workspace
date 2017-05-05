package com.pengrui.drink;

enum DrinkType {
	COFFEE,BEER,MILK
}

public abstract class Drink {
	private DrinkType drinktype;
	public static DrinkType getDrink(DrinkType drinktype) {
		System.out.println("你的选择是：");
		switch(drinktype) {
		case COFFEE : System.out.println(DrinkType.COFFEE);break;
		case BEER : System.out.println(DrinkType.BEER);break;
		case MILK : System.out.println(DrinkType.MILK);break;
		}
		return drinktype;
	}
}
