package com.pengrui.test12;

import java.util.ArrayList;
import java.util.List;

public class Manage {
	public List<Student> manage = new ArrayList<Student>();
	
	public int ageAve() {
		int sum = 0;
		for(Student stu : manage) {
			sum = sum + stu.getAge();
		}
		return sum / manage.size();
	}
	
	public double scoresAve(String classNum) {
		double sum = 0,i = 0;
		for(Student stu : manage) {
			if(stu.getClassNum().equals(classNum)){
				sum = sum + stu.getScores();
				i++;
			}
		}
		if(i == 0) {
			return 0;
		}
		return sum / i;
	}
}
