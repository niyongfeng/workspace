package com.qingke.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class SearchService {
	
	static Map<String,String> map = new HashMap<String,String>();
	
	static {
		map.put("hello", "你好");
		map.put("world", "世界");
		map.put("offer", "工作");
		map.put("man", "男");
		map.put("green", "绿");
	}
	
	public static String search(String word){
		String str = map.get(word);
		if(str == null) {
			return "找不到！";
		}
		return str;
	}
	
	public static void cun(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line;
		while(true) {
			line = br.readLine();
			if(line != null) {
				System.out.println("saving.......");
				addMap(line);
			}else {
				break;
			}
		}
	}
	
	public static void addMap(String line) {
		if(line != null) {
		String key = line.substring(0,line.indexOf(" ")).trim();
		String value = line.substring(line.indexOf(" ")).trim();
		map.put(key, value);
		}
	}
}
