package com.pengrui.map;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class LearnMap {
	public static void main(String[] args) {
	//	Map<String, Integer> map = new HashMap<String, Integer>();
	//	Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		Map<String, Integer> map = new TreeMap<String, Integer>();
	//增加元素
	
		map.put("张三", 88);
		map.put("李四", 77);
		map.put("王五", 89);
		map.put("赵信", 79);
		
	//获取元素
		
		System.out.println(map.get("李四"));
		
	//遍历方法
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry);
		}
	}
}

class KeyComparator implements Comparator<Map.Entry<String, Integer>> {

	public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
		return o1.getKey().compareTo(o2.getKey());
		
	}
}
