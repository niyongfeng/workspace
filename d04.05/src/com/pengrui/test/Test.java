package com.pengrui.test;

import java.util.Iterator;
import java.util.List;

import com.pengrui.dao.Dao;
import com.pengrui.object.Project;
import com.pengrui.object.User;
import com.pengrui.util.MyConsole;

public class Test {
	private static User user = new User();
	private static Project project = new Project();
	public static void main(String[] args) {
		one : while (true) {
			System.out.println("1.在user表中新加一条信息；");
			System.out.println("2.在project表中新加一条信息；");
			System.out.println("3.在user表中查询相关信息；");
			System.out.println("4.在project表中查询相关信息");
			System.out.println("5.在user表中删除有关信息；");
			System.out.println("6.在project表中删除有关信息；");
			System.out.println("7.在user表中更新有关信息；");
			System.out.println("8.在project表中更新有关信息；");
			System.out.println("9.退出；");
			int m = MyConsole.askUserInputInt();
			switch (m) {
			case 1:System.out.println("操作：" + Dao.insertUser(getUser(1)));break;
			case 2:System.out.println("操作：" + Dao.insertProject(getProject()));break;
			case 3:toString(Dao.searchUser(getUser(3)));break;
			case 4:toString(Dao.searchProject(getProject()));break;
			case 5:System.out.println("操作：" + Dao.deleteUser(getUser(5)));break;
			case 6:System.out.println("操作：" + Dao.deleteProject(getProject()));break;
			case 7:System.out.println("操作：" + Dao.updateUser(getUser(7)));break;
			case 8:System.out.println("操作：" + Dao.updateProject(getProject()));break;
			case 9:break one;
			default:System.out.println("指令有误");break;
			}
		}
	}

	
	public static Object getUser(int i) {
		if(i != 1) {
			System.out.println("请输入ID：");
			user.setId(MyConsole.askUserInputInt());
		}
		System.out.println("请输入姓名：");
		user.setName(MyConsole.askUserInput());
		System.out.println("请输入性别：");
		String gender = MyConsole.askUserInput();
		if("".equals(gender)) {
			gender = "false";
		}
		user.setGender(gender);
		System.out.println("请输入公司：");
		user.setCompany(MyConsole.askUserInput());
		System.out.println("请输入电话：");
		user.setPhone(MyConsole.askUserInput());
		return (Object)user;
	}

	public static Object getProject() {
		System.out.println("请输入编号：");
		project.setCode(MyConsole.askUserInput());
		System.out.println("请输入项目名：");
		project.setName(MyConsole.askUserInput());
		System.out.println("请输入项目描述：");
		project.setDescription(MyConsole.askUserInput());
		System.out.println("请输入项目人ID：");
		project.setUserId(MyConsole.askUserInputInt());
		return (Object)project;
		
	}
	
	public static void toString(List<?> list) {
		Iterator<?> it = list.iterator();
		while(it.hasNext()) {
			//it.next().toString();
			Object obj = it.next();
			if(obj instanceof User) {
				System.out.println(((User)obj).toString());
			}else if(obj instanceof Project) {
				System.out.println(((Project)obj).toString());
			}
		}
	}
}
