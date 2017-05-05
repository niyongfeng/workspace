package com.pengrui.LearnHashSet;

//import java.util.Iterator;
//import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class LearnLinkedHashSet {
	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>();
	//	Set<String> set = new LinkedHashSet<String>();
		set.add("abc");
		set.add("bcd");
		set.add("efg");
		set.add("fgh");
		set.add("ccc");
		
	//	Iterator<String> it = set.iterator();
		for(String s : set) {
			System.out.println(s);
		}
	}
}
