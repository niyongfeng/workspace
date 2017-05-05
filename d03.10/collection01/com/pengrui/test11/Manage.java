package com.pengrui.test11;

import java.util.ArrayList;
import java.util.List;

public class Manage {
	static List<Worker> list = new ArrayList<Worker>();
	
	public static void print() {
		for(Worker worker : Manage.list) {
			System.out.println(worker.toString());
		}
	}
}
