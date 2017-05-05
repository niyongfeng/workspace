package com.pengrui.interfac;

public class Gov {
	
	EnvStandard pro;
	
	public void setPro(EnvStandard env) {
		pro = env;
	}
	public EnvStandard getPro() {
		return pro;
	}
	
	public static void main(String[] args) {
		Gov g = new Gov();
		g.setPro(new Person());
		g.getPro().clean();
		g.getPro().recycle();
		g.setPro(new Company());
		g.getPro().clean();
		g.getPro().recycle();
		g.setPro(new College());
		g.getPro().clean();
		g.getPro().recycle();
		
		
		
	}
}
