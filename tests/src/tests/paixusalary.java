package tests;

public class paixusalary {
	public String xingxi;
	public String salary;
	public  paixusalary(String xingxi) {
		this.xingxi = xingxi;
		if(xingxi.substring(0,2).equals("01")) {
			this.salary = xingxi.substring(6,10);
		}else {
			this.salary = xingxi.substring(7,11);
		}
		
	}
	public int hashCode() {
		String str = this.salary;
		return str.hashCode();
	}
	public boolean equals(Object anotherObject) {
		paixusalary p = (paixusalary) anotherObject;
		return	this.salary.equals(p.salary);
	}
	public int compareTo(Object anotherObject) {
		paixusalary p = (paixusalary) anotherObject;
		int a = Integer.parseInt(this.salary);
		int b = Integer.parseInt(p.salary);
		if(a > b) return 1;
		else if(a == b) return 0;
		else return -1;
	}
}
