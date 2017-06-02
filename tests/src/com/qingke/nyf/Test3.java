package com.qingke.nyf;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.google.gson.Gson;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "{'dates':[{'year':1999,'month':12,'day':1},{'year':1999,'month':12,'day':5},{'year':1998,'month':12,'day':5}]}";
		Gson gson = new Gson();
		Dates dates = gson.fromJson(str, Dates.class);
		//System.out.println(dates.getDates().get(0));
		Date date1 = dates.getDates().get(0);
		Date date2 = dates.getDates().get(1);
		Date date3 = dates.getDates().get(2);
		System.out.println(date1.compareTo(date2));
		Set<Date> set = new TreeSet<Date>(new bijiao());
		set.add(date1);
		set.add(date2);
		set.add(date3);
		System.out.println(set);
		Map<String,Integer> map = new TreeMap();
		map.put("a", 1);
		map.put("b", 3);
		map.put("c", 2);
		map.put("c", map.get("c") + 1);
		System.out.println(map.get("c"));
	}

}

class bijiao implements Comparator<Date>{

	@Override
	public int compare(Date o1, Date o2) {
		if(o2.getYear() > o1.getYear()) {
			System.out.println(o2.getYear());
			return -1;
		}else if(o2.getYear() < o1.getYear()) {
			System.out.println(o1.getYear());
			return 1;
		}else {
			if(o2.getMonth() > o1.getMonth()) {
				System.out.println(o2.getMonth());
				return -1;
			}else if(o2.getMonth() < o1.getMonth()) {
				System.out.println(o1.getMonth());
				return 1;
			}else {
				if(o2.getDay() > o1.getDay()) {
					System.out.println(o2.getDay());
					return -1;
				}else if(o2.getDay() < o1.getDay()) {
					System.out.println(o1.getDay());
					return 1;
				}else {
					return 0;
				}
			}
		}
	}
	
	
}
