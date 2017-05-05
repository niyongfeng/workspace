package com.pengrui.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pengrui.object.Project;
import com.pengrui.object.User;

public class Dao {
	private static Connection con = null;
	private static JDBConnection jdbc = null;
	private static PreparedStatement ps = null;
	private static ResultSet res = null;
	private static User user = null;
	private static Project project = null;

	static {
		jdbc = JDBConnection.getInstance();
		con = jdbc.getConnection();
	}

	public static List<User> searchUser(Object obj) {
		List<User> list = new ArrayList<User>();
		if (obj instanceof User) {
			user = (User) obj;
			int id = user.getId();
			String name = user.getName();
			String gender = user.isGender();
			String company = user.getCompany();
			String phone = user.getPhone();
			try {
				if (id != 0) {
					ps = con.prepareStatement("select * from user where id = ?");
					ps.setInt(1, id);
				} else if (!(company.equals(""))) {
					ps = con.prepareStatement("select * from user where company = ?");
					ps.setString(1, company);
				} else if (!(phone.equals(""))) {
					ps = con.prepareStatement("select * from user where mobile_phone = ?");
					ps.setString(1, phone);
				} else if (!(name.equals(""))) {
					ps = con.prepareStatement("select * from user where name = ?");
					ps.setString(1, name);
				} else if (!(gender.equals(""))) {
					ps = con.prepareStatement("select * from user where gender = ?");
					ps.setString(1, gender);
				}
				// else
				// if(id != 0){
				// ps = con.prepareStatement("select * from user where id = ?");
				// ps.setInt(1, id);
				// }
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					User u = new User();
					u.setId(res.getInt(1));
					u.setName(res.getString(2));
					u.setGender(res.getString(3));
					u.setCompany(res.getString(4));
					u.setPhone(res.getString(5));
					list.add(u);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static List<Project> searchProject(Object obj) {
		List<Project> list = new ArrayList<Project>();
		if (obj instanceof Project) {
			project = (Project) obj;
			String code = project.getCode();
			String name = project.getName();
			int userId = project.getUserId();
			try {
				if (!("".equals(code))) {
					ps = con.prepareStatement("select * from project where code = ?");
					ps.setString(1, code);
				} else if (!("".equals(name))) {
					ps = con.prepareStatement("select * from project where name = ?");
					ps.setString(1, name);
				} else if (userId != 0) {
					ps = con.prepareStatement("select * from project where user_id = ?");
					ps.setInt(1, userId);
				}
				ps.execute();
				res = ps.getResultSet();
				while (res.next()) {
					Project p = new Project();
					p.setCode(res.getString(1));
					p.setName(res.getString(2));
					p.setDescription(res.getString(3));
					p.setDatetimes(res.getDate(4) + "");
					p.setUserId(res.getInt(5));
					list.add(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public static boolean insertUser(Object obj) {
		if (obj instanceof User) {
			user = (User) obj;
			// int id = user.getId();
			String name = user.getName();
			String gender = user.isGender();
			String company = user.getCompany();
			String phone = user.getPhone();
			try {
				ps = con.prepareStatement("insert into user(name,gender,company,mobile_phone) value (?,?,?,?)");
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setString(3, company);
				ps.setString(4, phone);
				return !ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean insertProject(Object obj) {
		if (obj instanceof Project) {
			project = (Project) obj;
			String code = project.getCode();
			String name = project.getName();
			String description = project.getDescription();
			int userId = project.getUserId();
			// System.out.println(userId);
			try {
				ps = con.prepareStatement("insert into project(code,name,description,user_id) value (?,?,?,?)");
				ps.setString(1, code);
				ps.setString(2, name);
				ps.setString(3, description);
				ps.setInt(4, userId);
				return !ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean deleteUser(Object obj) {
		if (obj instanceof User) {
			user = (User) obj;
			int id = user.getId();
			String name = user.getName();
			String gender = user.isGender();
			String company = user.getCompany();
			String phone = user.getPhone();

			Project p = new Project();
			p.setUserId(searchUser(user).get(0).getId());
			if (searchProject(p).iterator().hasNext()) {
				// p.setUserId(searchUser(user).get(0).getId());
				deleteProject(searchProject(p).get(0));
			}

			try {
				// ps = con.prepareStatement("delete from user where name = ?");
				// ps.setString(1, name);
				if (id != 0) {
					ps = con.prepareStatement("delete from user where id = ?");
					ps.setInt(1, id);
				} else if (!(company.equals(""))) {
					ps = con.prepareStatement("delete from user where company = ?");
					ps.setString(1, company);
				} else if (!(phone.equals(""))) {
					ps = con.prepareStatement("delete from user where mobile_phone = ?");
					ps.setString(1, phone);
				} else if (!(name.equals(""))) {
					ps = con.prepareStatement("delete from user where name = ?");
					ps.setString(1, name);
				} else if (!(gender.equals(""))) {
					ps = con.prepareStatement("delete from user where gender = ?");
					ps.setString(1, gender);
				}

				return !ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean deleteProject(Object obj) {
		if (obj instanceof Project) {
			project = (Project) obj;
			String code = project.getCode();
			String name = project.getName();
			int userId = project.getUserId();
			try {
				if (!("".equals(code))) {
					ps = con.prepareStatement("delete from project where code = ?");
					ps.setString(1, code);
				} else if (!("".equals(name))) {
					ps = con.prepareStatement("delete from project where name = ?");
					ps.setString(1, name);
				} else if (userId != 0) {
					ps = con.prepareStatement("delete from project where user_id = ?");
					ps.setInt(1, userId);
				}
				return !ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean updateUser(Object obj) {
		if (obj instanceof User) {
			user = (User) obj;
			int id = user.getId();
			String name = user.getName();
			String gender = user.isGender();
			String company = user.getCompany();
			String phone = user.getPhone();

			try {
				//
				ps = con.prepareStatement(
						"update user set name = ?, gender = ?, company = ?, mobile_phone = ? where id = ?");
				ps.setString(1, name);
				ps.setString(2, gender);
				ps.setString(3, company);
				ps.setString(4, phone);
				ps.setInt(3, id);
				// System.out.println("1");
				int n = ps.executeUpdate();
				// con.commit();
				if (n != 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public static boolean updateProject(Object obj) {
		if (obj instanceof Project) {
			project = (Project) obj;
			String code = project.getCode();
			String name = project.getName();
			String description = project.getDescription();
			int userId = project.getUserId();

			try {
				ps = con.prepareStatement("update project set name = ?, description = ?, user_id = ? where code = ?");
				ps.setString(1, name);
				ps.setString(2, description);
				ps.setInt(3, userId);
				ps.setString(4, code);
				int n = ps.executeUpdate();
				if (n != 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
