package com.qingke.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qingke.pojo.Dictionary;

public class SearchService {
	public static List<Dictionary> list = new ArrayList<Dictionary>();
	public static List<Dictionary> list1 = new ArrayList<Dictionary>();
	public static String str = "";
	
	public static List<Dictionary> search(String word){
		list = ReaderSqlService.getDictionaryDao().selectByWord(word);
		System.out.println(list);
		return list;
	}
	
	public static void cun(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line;
		while(true) {
			line = br.readLine();
			if(line != null) {
				System.out.println(line);
				addList(line);
			}else {
				break;
			}
		}
	}
	
	public static void addList(String line) {	
		if(line != null) {
			String key = line.trim().substring(0, line.indexOf(" ")).trim();
			String value = line.trim().substring(line.indexOf(" ")).trim();
			Dictionary d = new Dictionary();
			d.setWord(key);
			d.setDescription(value);
			if(ReaderSqlService.getDictionaryDao().selectByWord1(key).size() == 0) {
				list.add(d);
				ReaderSqlService.getDictionaryDao().insert(d);
				ReaderSqlService.getSession().commit();
			}else {
				str = str + d.getWord() + ":" + d.getDescription() + "<br/>";
				System.out.println("这条信息已经存在：" + d);
			}
		}
	}
}
