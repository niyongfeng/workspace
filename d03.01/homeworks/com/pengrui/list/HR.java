package com.pengrui.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HR {
	
	public List<Employee> hr = new LinkedList<Employee>();
	
	public HR() {
		for(int i = 0; i < 20; i++) {
			Employee employee = new Employee(randomName(),randomId(),randomPrice());
			hr.add(employee);
		}
		
	}
	
	public static String randomName() {
		Random r = new Random();
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String name = "";
		for(int i = 0;i < 3; i++) {
			name = name + base.charAt((int)r.nextInt(26));
		}
		return name;
	}
	
	public static String randomId() {
		Random r = new Random();
		String base = "0123456789";
		String id = "";
		for(int i = 0;i < 5; i++) {
			id = id + base.charAt((int)r.nextInt(10));
		}
		return id;
	}
	
	public static int randomPrice() {
		Random r = new Random();
		int price = 5000;
		price = price + r.nextInt(3000);
		return price;
	}
	
	public List<Employee> getEmployees() {
		return hr;
	}
	
	public Employee getTopSalaryEmployee() {
		int index = 0, indexMax = 0;
		int max = 0;
		while(index < hr.size()) {
			if(max < hr.get(index).getPrice()) {
				max = hr.get(index).getPrice();
				indexMax = index;
			}
			index++;
		}
		return hr.get(indexMax);
	}
	
	public void enrollEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入员工姓名：");
		String strName = sc.next();
		System.out.println("请输入员工工号：");
		String strId = sc.next();
		System.out.println("请输入员工工资：");
		int price = sc.nextInt();
		hr.add(new Employee(strName, strId, price));
		sc.close();
	}
	
	public void resignEmployee(String employeeId) {
		int index = 0;
		int l = hr.size(), h;
		while(index < hr.size()) {
			if(hr.get(index).getId().equals(employeeId)) {
				hr.remove(index);
			}
			index++;
		}
		h = hr.size();
		if(l == h) {
			System.out.println("找不到对应的员工！");
		}else {
			System.out.println("员工离职手续已办!");
		}
	}
	
	public boolean isOurEmployee(Employee employee) {
		int index = 0;
		boolean b = false;
		while(index < hr.size()) {
			if(hr.get(index).getId().equals(employee.getId()) && hr.get(index).getName().equals(employee.getName()) 
					&& hr.get(index).getPrice() == employee.getPrice()) {
				b = true;
				break;
			}
			index++;
		}
		return b;
	}

	public List<Employee> getTop10SalaryEmployees() {
		List<Employee> l = new LinkedList<Employee>();
		List<Employee> l1 = new LinkedList<Employee>();
		for(Employee e : hr) {
			l.add(e);
		}
		while(l1.size() <= 10) {
			int index = 0, max = 0, indexmax = 0;
			while(index < l.size()) {
				if(max < l.get(index).getPrice()) {
					max = l.get(index).getPrice();
					indexmax = index;
				}
				index++;
			}
			l1.add(l.get(indexmax));
			l.remove(indexmax);
		}
		return l1;
	}
	
	public void print() {
		int index = 0;
		while(index < hr.size()) {
			System.out.println(hr.get(index).toString());
			index++;
		}
	}
}
