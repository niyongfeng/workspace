package com.testpaper;

public class TestUser {

	public static void main(String[] args) {
		
		User user1 = new User(110708132, "nyf12345");
		User user2 = new User(110708132, "ni12345", "495970749@qq.com");
		
		System.out.println(user1.toString());
		System.out.println(user2.toString());
		
	}
}
