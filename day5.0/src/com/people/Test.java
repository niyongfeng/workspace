package com.people;

public class Test {
	public static void main(String[] arges) {
		People people = new People("nyf", "shaoxing");
		Student student = new Student("qyt", "shijiazhuang", "java", 4, 14800.0);
		Staff staff = new Staff("litian", "hangzhou", "浙江传媒学院", 10000);
		
		System.out.println(people.toString());
		System.out.println(student.toString());
		System.out.println(staff.toString());
		
		Student student1 = new Student(people.getName(), people.getAddress(), "java" , 4, 14800.0);
		System.out.println(student1.toString());
		
		Staff staff1 = new Staff(people.getName(), people.getAddress(), "浙江传媒学院", 10000);
		System.out.println(staff1.toString());
		
	}

}
