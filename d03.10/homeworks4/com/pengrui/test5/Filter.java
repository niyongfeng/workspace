package com.pengrui.test5;

public interface Filter {
	default void print() {
		System.out.println("过滤！");
	}
}
