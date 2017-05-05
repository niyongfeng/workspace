package com.pengrui.authorbook;

public class TestAuthor {

	public static void main(String[] args) {
		Author a = new Author("nyf", "110@qq.com", 'f');
		System.out.println(a.toString());
		a.setEmail("495970749@qq.com");
		a.setGender('m');
		System.out.println(a.toString());
		
		
		Author a1 = new Author("niyongfeng", "495970749@qq.com", 'f');
		System.out.println("本体：" + a1.toString());
		Author a2 = (Author)a1.clone();
		System.out.println("克隆体：" + a2.toString());
		System.out.println("本体哈希码值：" + a1.hashCode());
		System.out.println("克隆体哈希码值：" + a2.hashCode());
		System.out.println(a1.equals(a2));
	}
}
