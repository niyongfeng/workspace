package com.qingke.pojo;

public class Dictionary {
	
	private int id;
	private String word;
	private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Dictionary [id=" + id + ", word=" + word + ", description=" + description + "]";
	}
	
	

}
