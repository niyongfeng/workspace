package com.pengrui.authorbook;

public class Book {
	
	private String name;
	public Author author;
	private double price;
	private int qty;
	
	public Book(String name, Author author, double price) {
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	public Book(String name, Author author, double price, int qty) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	public String getName() {
		return name;
	}
	
	public Author getAuthor() {
		return author;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int qty() {
		return qty;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	public String toString() {
		return "Book [ name = " + name + ", " + author.toString() + ", price = " + price + ", qty = " + qty + " ]";
	}
	
	public int hashCode() {
		String str = name + price + qty + author;
		return str.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Book)) return false;
		
		Book b = (Book) obj;
		return b.name == name && b.author.getName() == author.getName() && b.author.getEmail() == author.getEmail() &&
				b.author.getGender() == author.getGender() && b.price == price && b.qty == qty;
	}
	
	public Object clone() {
		Author aut = new Author(author.getName(), author.getEmail(), author.getGender());
		Book b = new Book(name, aut, price, qty);
		return b;
	}

}
