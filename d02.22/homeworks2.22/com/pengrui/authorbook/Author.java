package com.pengrui.authorbook;

public class Author {

	private String name;
	private String email;
	private char gender;
	
	public Author(String name, String email, char gender) {
		this.name = name;
		this.email = email;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public char getGender() {
		return gender;
	}
	
	public String toString() {
		return "Author [ name = " + name + ", email = " + email + "gender = " + gender + " ]";
	}
	
	public int hashCode() {
		String str = name + email + gender;
		return str.hashCode();
	}
	
	public boolean equals(Object obj) {
		if(!(obj instanceof Author)) return false;
		
		Author a = (Author) obj;
		return a.name == name && a.email == email && a.gender == gender;
	}
	
	public Object clone() {
		Author aut = new Author(name, email, gender);
		return aut;
	}
}
