package com.pengrui.list;


public class Test {
	public static void main(String[] args) {
		HR hr1 = new HR();
		Employee e = new Employee("KFC","99999",6000);
		hr1.print();
		System.out.println("工资最高的员工：" + hr1.getTopSalaryEmployee().toString());
		hr1.enrollEmployee();
		System.out.println("新员工入职后：");
		hr1.print();
		System.out.println("查找KFC,99999,6000员工");
		System.out.println(hr1.isOurEmployee(e));
		System.out.println("员工离职后：");
		hr1.resignEmployee("99999");
		hr1.print();
		System.out.println("查找KFC,99999,6000员工");
		System.out.println(hr1.isOurEmployee(e));
		
		System.out.println("工资前十：");
		for(Employee ll : hr1.getTop10SalaryEmployees()) {
			System.out.println(ll);
		}
	}
}
