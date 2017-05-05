package com.qingke.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.CollationKey;
import java.text.Collator;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Test extends Info{

	//文件地址
	private String filePath = "/users/niyongfeng/info.txt";
	File file = new File(filePath);
	//Map用于存储文本导进来的数据
	Map<Integer,Info> map = new TreeMap<Integer,Info>();
	//标题栏
	private String headLine;
	
	//初始化，将.txt文件中的内容存储到Map集合中
	public Test() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		headLine = br.readLine().substring(1);
		String info = br.readLine();
		while(info != null) {
			Info person = new Info();
			person.setId1(info.substring(0, info.indexOf(",")));
			info = info.substring(info.indexOf(",") + 1);
			person.setArea(info.substring(0, info.indexOf(",")));
			info = info.substring(info.indexOf(",") + 1);	
			person.setSalary(Integer.parseInt(info.substring(0, info.indexOf(","))));
			info = info.substring(info.indexOf(",") + 1);
			person.setId2(info.substring(0, info.indexOf(",")));
			info = info.substring(info.indexOf(",") + 1);
			person.setName(info);
			map.put(person.hashCode(),person);
			info = br.readLine();
		}
		br.close();
	}
	//help帮助，用户可以通过help指令查看控制台的指令用法
	public void help() {
		System.out.println("help:");
		System.out.println("ls [-all][ID] 可以输出[对应ID]记录的基本[详细]信息。-all, ID 参数为可选项。");
		System.out.println("find [-name|-salary][value] 可以搜索并打印按[名字|平均收入]为条件的记录。");
		System.out.println("find -salary 搜索条件的取值必须符合“全数字”或者“数字~数字”的格式。\n当取值为全数字时，按大于等于条件搜索。当取值为“数字 ~ 数字”时，按区间搜索，包含相等的值。");
		System.out.println("sort [-name|-salary] 可以输出按 [名字|平均收]排序后的基本信息。 -name, -salary为可选项，默认按 ID 排序。");
	}
	//ls -all指令
	public void ls(String str) throws IOException {
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		System.out.println(headLine);
		if(str.equals("-all")) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#"))) {
					System.out.println(i.toString());
				}
			}
		}
	}
	//ls [-all][ID]指令
	public void ls(String str, String id) {
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		System.out.println(headLine);
		int count1 = 0;
		int count2 = 0;
		if(str.equals("")) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#")) && id.equals(i.getId1())) {
					System.out.println(i.toString());
					count1++;
				}
			}
			if(count1 == 0) {
				System.out.println("查无此信息！");
			}
		}else if(str.equals("-all")) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#")) && (id.equals(i.getId1()) || id.equals(i.getId2()))) {
					System.out.println(i.toString());
					count2++;
				}
			}
			if(count2 == 0) {
				System.out.println("查无此信息！");
			}
		}
	}
	//find -name [value]指令
	public void find(String str, String name) {
		int count = 0;
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		System.out.println(headLine);
		if(str.equals("-name") && name !=null) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#")) && i.getArea().contains(name)) {
					System.out.println(i.toString());
					count++;
				}
			}
			if(count == 0) {
				System.out.println("查无此信息！");
			}
		}
	}
	//find -salary [value]指令，value值为全数字
	public void find(String str, int salary) {
		int count = 0;
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		System.out.println(headLine);
		if(str.equals("-salary")) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#")) && i.getSalary() >= salary) {
					System.out.println(i.toString());
					count++;
				}
			}
			if(count == 0) {
				System.out.println("查无此信息！");
			}
		}
	}
	//find -salary [value]指令，value值为范围值
	public void find1(String str, String salary) {
		int count = 0;
		int salary1 = Integer.parseInt(salary.substring(0,salary.indexOf("~")));
		int salary2 = Integer.parseInt(salary.substring(salary.indexOf("~") + 1));
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		System.out.println(headLine);
		if(str.equals("-salary")) {
			while(it.hasNext()) {
				Info i = it.next().getValue();
				if(!(i.getId1().contains("#")) && i.getSalary() >= salary1 && i.getSalary() <= salary2) {
					System.out.println(i.toString());
					count++;
				}
			}
			if(count == 0) {
				System.out.println("查无此信息！");
			}
		}
	}
	//sort [-name | -salary]指令
	public void sort(String str) {
		Set<Info> set = null;
		System.out.println(headLine);
		if(str.equals("-name")) {
			set = new TreeSet<Info>(new NameComparator());
		}else if(str.equals("-salary")) {
			set = new TreeSet<Info>(new SalaryComparator());	
		}
		Iterator<Map.Entry<Integer, Info>> it = map.entrySet().iterator();
		while(it.hasNext()) {
			Info i = it.next().getValue();
			if(!(i.getId1().contains("#"))) {
				set.add(i);
			}
		}
		for(Info info : set) {
			System.out.println(info.toString());
		}
	}

}
//用于汉字排序比较器
class NameComparator implements Comparator<Info> {
	Collator collator = Collator.getInstance();

	public int compare(Info o1, Info o2) {
		CollationKey key1 = collator.getCollationKey(o1.getArea());
		CollationKey key2 = collator.getCollationKey(o2.getArea());
		CollationKey name1 = collator.getCollationKey(o1.getName());
		CollationKey name2 = collator.getCollationKey(o2.getName());
		if(key1.equals(key2)) {
			if(name1.equals(name2)) {
				if(o1.getSalary() < o2.getSalary()) {
					return -1;
				}else if(o1.getSalary() > o2.getSalary()) {
					return 1;
				}else {
					return 0;
				}
			}else {
				return name1.compareTo(name2);
			}
		}else {
			return key1.compareTo(key2);
		}

	}
}

//用于salary排序的比较器
class SalaryComparator implements Comparator<Info> {
	Collator collator = Collator.getInstance();
	
	public int compare(Info o1, Info o2) {
		CollationKey key1 = collator.getCollationKey(o1.getArea());
		CollationKey key2 = collator.getCollationKey(o2.getArea());
		CollationKey name1 = collator.getCollationKey(o1.getName());
		CollationKey name2 = collator.getCollationKey(o2.getName());
		if(o1.getSalary() < o2.getSalary()) {
			return -1;
		}else if(o1.getSalary() > o2.getSalary()) {
			return 1;
		}else {
			if(o1.getName().equals(o2.getName())) {
				return key1.compareTo(key2);
			}else {
				return name1.compareTo(name2);
			}
		}
	}
	
}
