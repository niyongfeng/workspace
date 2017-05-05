package cim.pengrui.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class LearnCollection {
	public static void main(String[] args) {
		Collection<String> co;
		co = new ArrayList<String>();
		System.out.println(co.isEmpty());
		co.add("第五");
		co.add("第一");
		co.add("第二");
		co.add("第三");
		System.out.println(co.isEmpty());
		
		System.out.println(co.contains("第一"));
		System.out.println(co.contains("第四"));
		
		System.out.println("remove前有：" + co.size());
		co.remove("第一");
		System.out.println("remove之后有：" + co.size());
		
		System.out.println(co.toString());
		
		//遍历器
		Iterator<String> t = co.iterator();
		while(t.hasNext()) {
			String t1 = t.next();
			System.out.println(t1);
		}
		//foreach
		for(String s : co) {
			System.out.println(s);
		}
		
		
		
		
	}
}
