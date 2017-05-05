package com.pengrui.learnserializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StudentTest {

	public static void main(String[] args) {
		Student stu = new Student("niyongfeng","man",26);
		
		System.out.println("original:" + stu);
		input(stu);
		
		Student stu2 = output();
		System.out.println("peristed:" + stu2);
	}
	
	public static void input(Student student) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("student.output"));
			oos.writeObject(student);
			oos.flush();
			
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Student output() {
		ObjectInputStream ois = null;
		Student stu = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("student.output"));
			Object obj = ois.readObject();
			if(obj instanceof Student) {
				stu = (Student) obj;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return stu;
	}
}
