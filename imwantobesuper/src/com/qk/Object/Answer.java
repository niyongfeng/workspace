package com.qk.Object;

public class Answer {
	private int id;
	private String value;
	private String best;
	private int player_id;
	private int question_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getBest() {
		return best;
	}
	public void setBest(String best) {
		this.best = best;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", value=" + value + ", best=" + best
				+ ", player_id=" + player_id + ", question_id=" + question_id
				+ "]";
	}
	
}
