package com.pengrui.jaxb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {
	public static void main(String[] args) {
		Student stu = new Student("nyf", "man",20);
		Student stu1 = new Student("niyongfeng", "man", 18);
		stu.setId(110708132);
		
		JAXBContext con;
		try {
			File file = new File("Student.xml");
			FileWriter fw = new FileWriter(file);
			con = JAXBContext.newInstance(Student.class);
			Marshaller m = con.createMarshaller();
			m.marshal(stu, fw);
			//m.marshal(stu1, fw);
			
			Unmarshaller un = con.createUnmarshaller();
			Object obj = un.unmarshal(new File("Student.xml"));
			if(obj instanceof Student) {
				Student s = (Student) obj;
				System.out.println(s.toString());
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
