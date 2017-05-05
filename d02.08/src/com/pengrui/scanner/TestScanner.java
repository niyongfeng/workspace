package com.pengrui.scanner;

import java.util.Scanner;

public class TestScanner {
	
	public static void main(String[] args) {
		/*
		 * 测试多个int值输入
		 */
/*
		int a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		f = sc.nextInt();
		g = sc.nextInt();
		h = sc.nextInt();
		i = sc.nextInt();
		j = sc.nextInt();
		k = sc.nextInt();
		l = sc.nextInt();
		m = sc.nextInt();
		n = sc.nextInt();
		o = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		r = sc.nextInt();
		s = sc.nextInt();
		t = sc.nextInt();
		u = sc.nextInt();
		v = sc.nextInt();
		w = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(i);
		System.out.println(j);
		System.out.println(k);
		System.out.println(l);
		System.out.println(m);
		System.out.println(n);
		System.out.println(o);
		System.out.println(p);
		System.out.println(q);
		System.out.println(r);
		System.out.println(s);
		System.out.println(t);
		System.out.println(u);
		System.out.println(v);
		System.out.println(w);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		sc.close();
*/
		
		/*
		 * 测试多个String输入
		 */
/*		
		String a,b,c,d,e,f,g;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLine();
		b = sc.nextLine();
		c = sc.nextLine();
		d = sc.nextLine();
		e = sc.nextLine();
		f = sc.nextLine();
		g = sc.nextLine();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		sc.close();
*/
		
		/*
		 * 测试int 和 String输入
		 * String b = sc.nextLine()；会截取上个回车，导致程序出现错误，应该改为String b = sc.next();
		 */
		
		int a;
		String b;
		int c;
		String d;
		int e;
		String f;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.next();
		c = sc.nextInt();
		d = sc.next();
		e = sc.nextInt();
		f = sc.next();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		sc.close();
	}

}
