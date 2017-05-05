package com.pengrui.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StudentManage extends StudentInformation{
	String filePath = "/users/niyongfeng/Student.txt";
	File file = new File(filePath);
	Set<StudentInformation> student = new TreeSet<StudentInformation>(new TotalComparator());
	
	public StudentManage() throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("Name" + " " + "MathScore" + " " + "EnglishScore" + " " + "ChineseScore" + " " + "TotalScore");
		bw.close();
	}
	
	public void entering(StudentInformation stu) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		student.add(stu);
		Iterator<StudentInformation> it = student.iterator();
		while(it.hasNext()) {
			StudentInformation s = it.next();
			bw.write(s.getName() + " " + s.getMath() + " " + s.getEnglish() + " " + s.getChinese() + " " + s.total() + "\n");
		}
		bw.close();
	}
	
	public void print() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		System.out.println("Name" + " " + "MathScore" + " " + "EnglishScore" + " " + "ChineseScore" + " " + "TotalScore");
		String s = br.readLine();
		while(s != null) {
			System.out.println(s);
			s = br.readLine();
		}
		br.close();
	}
	
}

class TotalComparator implements Comparator<StudentInformation> {

	public int compare(StudentInformation o1, StudentInformation o2) {
		if(o1.total() == o2.total()) {
			return o1.getName().compareTo(o2.getName());
		}
		if(o1.total() < o2.total()) return 1;
		return -1;
	}
	
}