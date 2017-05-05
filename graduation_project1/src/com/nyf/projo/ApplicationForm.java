package com.nyf.projo;

public class ApplicationForm {

	private int id;
	private int student_id;
	private int volunteer_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getVolunteer_id() {
		return volunteer_id;
	}
	public void setVolunteer_id(int volunteer_id) {
		this.volunteer_id = volunteer_id;
	}
	@Override
	public String toString() {
		return "ApplicationForm [id=" + id + ", student_id=" + student_id + ", volunteer_id=" + volunteer_id + "]";
	}
	
}
