package nyf2;

public class TsetEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Employee employee0 = new Employee(); 
		Employee employee = new Employee(32,"ni","yongfeng",88);
		System.out.println(employee0.toString());
		System.out.println(employee.getName());
		System.out.println(employee.getAnnualSalary());
		System.out.println(employee.toString());
		System.out.println(employee.raiseSalary(50));
		System.out.println(employee.toString());
		
		
		
	}

}
