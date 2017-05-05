package com.qingke.easyjava;

public class DemoBean {
	private String name = "No one";
	public void say() {
		System.out.println("DemoBean:say:"+name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
