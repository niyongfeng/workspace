package com.pengrui.besuper.pojo;

public class Player {
	private int id;
	private String name;
	private String pwd;
	private int scores;
	
	public Player() {
		
	}
	
	public Player(int id, String name, String pwd, int scores) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.scores = scores;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getScores() {
		return scores;
	}
	public void setScores(int scores) {
		this.scores = scores;
	}
	
	
}
