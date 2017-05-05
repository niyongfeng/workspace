package tests;

public class paixuname {
	public String xingxi;
	public String name;
	public paixuname(String xingxi) {
		this.xingxi = xingxi;
		if(xingxi.substring(0,2).equals("01")) {
			this.name = xingxi.substring(3,5);
		}else {
			this.name = xingxi.substring(3,6);
		}
	}
	public int hashCode() {
		String s = name ;
		return s.hashCode();
	}
	public boolean equals(Object anotherObject) {
		paixuname p = (paixuname) anotherObject;
		return	name.equals(p.name);
	}
}
