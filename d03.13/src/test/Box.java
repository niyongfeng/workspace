package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box extends Puker{
	
	public static List<Puker> list = new ArrayList<Puker>();
	String a = "";
	String folderPath = "/users/niyongfeng/DouDiZhu";
	public Box() {
		File fl = new File(folderPath);
		fl.mkdir();
	}
	
	public void ruffle() {
		for(int i = 3; i < 16; i++) {
			list.add(new Puker("红桃",i));
			list.add(new Puker("黑桃",i));
			list.add(new Puker("梅花",i));
			list.add(new Puker("方片",i));
		}
		
		list.add(new Puker("",17));
		list.add(new Puker("",18));
		
		Collections.shuffle(list);
	}
	
	public void cards() {
		System.out.println("底牌是：\n" + list.get(51).toString() + " " + list.get(52).toString() + " " + list.get(53).toString());
	}



}


