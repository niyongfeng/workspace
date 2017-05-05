package com.pengrui.foot;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Foot implements Cloneable{
	public Map<Integer, Foot> map = new LinkedHashMap<Integer, Foot>();
	public int number;
	public String winner;
	
	public Foot(int number, String winner) {
		this.number = number;
		this.winner = winner;
	}
	public Foot() {
		map.put(2006, new Foot(18, "意大利"));
		map.put(2002, new Foot(17, "巴西"));
		map.put(1998, new Foot(16, "法国"));
		map.put(1994, new Foot(15, "巴西"));
		map.put(1990, new Foot(14, "德国"));
		map.put(1986, new Foot(13, "阿根廷"));
		map.put(1982, new Foot(12, "意大利"));
		map.put(1978, new Foot(11, "阿根廷"));
		map.put(1974, new Foot(10, "德国"));
		map.put(1970, new Foot(9, "巴西"));
		map.put(1966, new Foot(8, "英格兰"));
		map.put(1962, new Foot(7, "巴西"));
		map.put(1958, new Foot(6, "巴西"));
		map.put(1954, new Foot(5, "德国"));
		map.put(1950, new Foot(4, "乌拉圭"));
		map.put(1938, new Foot(3, "意大利"));
		map.put(1934, new Foot(2, "意大利"));
		map.put(1930, new Foot(1, "乌拉圭"));
	}
	
	public void serch() {
		System.out.println("请输入一个年份：");
		Scanner sc = new Scanner(System.in);
		int year = sc.nextInt();
		String b = "没有举办世界杯！";
		Iterator<Map.Entry<Integer, Foot>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<Integer, Foot> entry = it.next();
			if(year == entry.getKey()) {
				b = entry.getKey() + ":" + entry.getValue().winner;
				break;
			}
		}
		System.out.println(b);
		sc.close();
	}
}
