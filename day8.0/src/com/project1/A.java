package com.project1;

public class A {
	String x = "123";
	public class B {
		public String toString() {
			return A.this.x;
			
		}
		
	}
	
	static class C {
		public String toString() {
			return "C";
		}
	}
	
	private class D {
		public String toString() {
			return "D";
		}
	}
	
	public String toString() {
		return "A";
	}
	
	public String to() {
		D d = new D();
		return d.toString();
	}
	

}
