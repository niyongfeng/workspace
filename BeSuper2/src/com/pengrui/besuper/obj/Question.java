package com.pengrui.besuper.obj;

public class Question {
	private int id;
	private String value;
	private int credit;
	private int player_id;
	private String isOpen;
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
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getPlayer_id() {
		return player_id;
	}
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", value=" + value + ", credit=" + credit
				+ ", player_id=" + player_id + ", isOpen=" + isOpen + "]";
	}

}
