package com.pengrui.classes;

import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;

public class Teacher {
	private String teacher;
	private String classes;
	public Map<String, String> map = new TreeMap<String,String>();
	
	public Teacher() {
		map.put("Tom", "CoreJava");
		map.put("John", "Oracle");
		map.put("Susan","Oracle");
		map.put("Jerry","JDBC");
		map.put("Jim","Unix");
		map.put("Kevin","JSP");
		map.put("Lucy","JSP");
	}
	
	public Teacher(String teacher, String classes) {
		this.teacher = teacher;
		this.classes = classes;
	}
	
	public void print() {
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
	public void change(Teacher t) {
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			if(entry.getKey().equals(t.teacher)) {
				entry.setValue(t.classes);
			}
		}
	}
	
	public void search(String classes) {
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			if(entry.getValue().equals(classes)) {
				System.out.println(entry.getKey());
			}
		}
	}
}
