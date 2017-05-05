package nyf2;

public class Employee {

	private int id = 55;
	private String firstName = "zhang";
	private String lastName = "san";
	private int salary = 66;

	//构造函数（无参）
	public Employee() {
		
	}
	
	//构造函数（有参）
	public Employee(int id, String firstName, String lastName, int salary) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	//getId()函数，返回id值
	public int getId() {
		return id;
	}

	//getFirstName()函数，返回firstName
	public String getFirstName() {
		return firstName;
	}

	//getLastName()函数，返回lastName
	public String getLastName() {
		return lastName;
	}

	//getName()函数，返回firstName+lastName
	public String getName() {
		return firstName + lastName;
	}

	//getSalary()函数，返回salary值
	public int getSalary() {
		return salary;
	}

	//setSalary(int salary)函数，获取salary值
	public void setSalary(int salary) {
		this.salary = salary;
	}

	//getAnnualsalary()函数，计算一年的总收入
	public int getAnnualSalary() {
		return salary * 12;
	}

	//raiseSalary(int percent)函数，计算涨动后的薪资
	public int raiseSalary(int percent) {
		salary = salary * (100 + percent) / 100;
		return salary;
	}

	//toString()函数，输出Employee的基本信息
	public String toString() {
		return "Employee[id=" + id + ',' + "name=" + firstName + lastName + ',' + "salary=" + salary + ']';
	}
}
