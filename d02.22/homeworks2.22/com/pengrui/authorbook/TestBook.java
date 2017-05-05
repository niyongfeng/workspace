package com.pengrui.authorbook;

public class TestBook {
	public static void main(String[] args) {
		Author a = new Author("nyf", "495970749@qq.com", 'm');
		Book b = new Book("上下五千年", a, 100, 99999);
		System.out.println(b.toString());
		b.setPrice(88);
		b.setQty(1000);
		System.out.println(b.toString());
		
		Book b1 = new Book("西游记", a, 100, 9999);
		Book b2 = (Book)b1.clone();
		System.out.println("本体哈希码值：" + b1.hashCode());
		System.out.println("克隆体哈希码值：" + b2.hashCode());
		System.out.println(b1.equals(b2));
		System.out.println("本体：" + b1.toString());
		b2.author.setGender('f');
		System.out.println("克隆体：" + b2.toString());
		System.out.println(b1.equals(b2));
	}
	
}
