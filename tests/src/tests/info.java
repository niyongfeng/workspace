package tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class info {
	public static void main(String[] args) {
		String filepath = "info.txt";
		File file = new File(filepath);
		boolean bl = true;
		System.out.println("欢迎来到本系统");
		System.out.println("====================");
		Scanner sc = new Scanner(System.in);
		do{
		System.out.println("输入你需要的操作");
		String mingling = sc.nextLine();
		if(mingling.equals("exit")) {
			bl = exit(bl);
		}else if(mingling.equals("help")){
			help();
		}else if(mingling.charAt(0) == 'I') {
			xingxi(file,mingling);
		}else if(mingling.charAt(0) == 'f') {
			chaxun(file,mingling);
		}else if(mingling.charAt(0) == 's') {
			paixu(file,mingling);
		}else {
			System.out.println("没有该命令请重新输入");
		}
		}while(bl);
		sc.close();
	}
	public static boolean exit(boolean bl) {
		System.out.println("已退出系统");
		bl = false;
		return bl;
	}
	public static void help() {
		System.out.println("ls[-all]/[ID] ——输出[all]/该[ID]对应的信息");
		System.out.println("find[-name|-salary][value] ——输出[name]或[salary]是[value]的地区");
		System.out.println("find -salary ——搜索条件的取值");
		System.out.println("sort [-name|-salary] ——按ID/[name]/[salsry]排序");
		System.out.println("exit ——退出系统");
	}
	public static void xingxi(File file,String str) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			if(str.length() == 7&&str.equals("Is -all")) {
				while(s != null ) {
					if(s.charAt(0) == '#') s = br.readLine();
					System.out.println(s);
					s = br.readLine();
				}
			}else if(str.length() == 5) {
				String str2 = str.substring(3,5);
				int count = 1;
				while(s != null ) {
					if(s.substring(0, 2).equals(str2)) {
						System.out.println(s);
						count--;
					}
					s = br.readLine();
				}
				if(count == 1) {
					System.out.println("没有该编号");
				}
			}else if(str.length() == 10 && str.substring(0, 8).equals("Is -all ")) {
				String str2 = str.substring(8,10);
				int count = 1;
				while(s != null ) {
					if(s.substring(0, 2).equals(str2)) {
						System.out.println(s);
						count--;
						if(str2.equals("01")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("02")||s.substring(0, 2).equals("04")||s.substring(0, 2).equals("11")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
							return ;
						}else if(str2.equals("02")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("05")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
							return;
						}else if(str2.equals("03")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("08")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
							return;
						}else if(str2.equals("04")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("07")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
							return;
						}else if(str2.equals("05")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("03")||s.substring(0, 2).equals("06")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
							return;
						}else if(str2.equals("08")) {
							while(s != null && s.charAt(0) != '#') {
								if(s.substring(0, 2).equals("09")) {
									System.out.println(s);
								}
								s = br.readLine();
							}
							br.close();
						return;
						}else if(str2.equals("11")) {
							FileReader fr2 = new FileReader(file);
							BufferedReader br2 = new BufferedReader(fr2);
							String s2 = br2.readLine();
							while(s != null ) {
								while(s2 != null) {
								if(s2.substring(0, 2).equals("10")||s2.substring(0, 2).equals("13")) {
									System.out.println(s2);
								}
								s2 = br2.readLine();
								}
								s = br.readLine();
							}
							br2.close();
						br.close();
						return;
						}
					}
					s = br.readLine();
				}
				if(count == 1) {
					System.out.println("没有该编号");
				}
			}else {
				System.out.println("没有该命令");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void chaxun(File file,String str) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			if(str.charAt(6) == 'n' && str.substring(0,11).equals("find -name ")) {
				String str2 = str.substring(11,str.length());
				int count = 1;
				while(s != null ) {
					if(s.charAt(0) =='#') s = br.readLine();
					else {
					if(s.contains(str2)) System.out.println(s);
					else count--;
					s = br.readLine();
					}
				}
				if(count <= 1) {
					System.out.println("未找到数据");
				}
			}else if(str.charAt(6) == 's') {
				if(str.length() == 17) {
				String str2 = str.substring(13,str.length());
				int count = 1;
				while(s != null ) {
					if(s.charAt(0) =='#') s = br.readLine();
					else {
					if(s.substring(0,2).equals("01")) {
						int a = s.substring(6,10).compareTo(str2);
						if(a > 0) System.out.println(s);
						count--;
					}else {
						int a = s.substring(7,11).compareTo(str2);
						if(a > 0) System.out.println(s);
						count--;
					}
					s = br.readLine();
					}
					if(count == 1) {
						System.out.println("没有数据");
					}
				}
				}else if(str.length() == 22) {
					String str2 = str.substring(13,17);
					String str3 = str.substring(18,str.length());
					int count = 1;
					while(s != null ) {
						if(s.charAt(0) =='#') s = br.readLine();
						else {
							if(s.substring(0,2).equals("01")) {
								int a = s.substring(6,10).compareTo(str2);
								int b = s.substring(6,10).compareTo(str3);
								if(a >= 0 && b <= 0) {
									System.out.println(s);
									count--;
								}
							}else {
								int a = s.substring(7,11).compareTo(str2);
								int b = s.substring(7,11).compareTo(str3);
								if(a >= 0 && b <= 0) {
									System.out.println(s);
									count--;
								}
							}
							s = br.readLine();
						}
					}
					if(count == 1) {
						System.out.println("没有数据");
					}
				}else {
					System.out.println("没有该命令");
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void paixu(File file,String str) {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s = br.readLine();
			if(str.charAt(6) =='n' && str.length() == 10) {
				Set<paixuname> mapname = new TreeSet<paixuname>(new nameComparator());
				while(s != null) {
					if(s.charAt(0) == '#') s = br.readLine();
					else {
						mapname.add(new  paixuname(s));
						s = br.readLine();
					}
				}
				Iterator< paixuname> it = mapname.iterator();
				while(it.hasNext()) {
					paixuname pn = it.next();
					System.out.println(pn.xingxi);
				}
			}else if(str.charAt(6) =='s' && str.length() == 12) {
				Set<paixusalary> mapsalary = new TreeSet<paixusalary>(new salaryComparator());
				while(s != null) {
					if(s.charAt(0) == '#') s = br.readLine();
					else {
						mapsalary.add(new paixusalary(s));
						s = br.readLine();
					}
				}
				Iterator<paixusalary> it = mapsalary.iterator();
				while(it.hasNext()) {
					paixusalary ps = it.next();
					System.out.println(ps.xingxi);
				}
				String filepath2 = "/user/result.txt";
				File file2 = new File(filepath2);
				file2.createNewFile();
				FileWriter fw = new FileWriter(file2);
				BufferedWriter bw = new BufferedWriter(fw);
				Iterator<paixusalary> it2 = mapsalary.iterator();
				while(it2.hasNext()) {
					paixusalary ps = it2.next();
					bw.write(ps.xingxi + "\r\n");
				}
				bw.close();
			}else {
				System.out.println("不存在该命令");
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
class salaryComparator implements Comparator<paixusalary>{  
	public int compare(paixusalary p1,paixusalary p2) {  
        int num1 = Integer.parseInt(p1.salary);  
        int num2 = Integer.parseInt(p2.salary);
        if(num1 > num2) return -1;
        else if(num1 == num2) return 0;
        else return 1;
    }  
 }  
class nameComparator implements Comparator<paixuname>{  
	public int compare(paixuname p1,paixuname p2) {  
		return p1.name.compareTo(p2.name);
    }  
 } 
