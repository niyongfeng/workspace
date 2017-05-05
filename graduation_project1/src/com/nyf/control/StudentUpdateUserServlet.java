package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.UserDao;
import com.nyf.projo.User;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class StudentUpdateUserServlet
 */
@WebServlet("/StudentUpdateUserServlet")
public class StudentUpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentUpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		SqlSession session = MybatisSessionFactory.getSession();
		UserDao ud = session.getMapper(UserDao.class);
		String name = request.getSession().getAttribute("userName").toString();
		String student_number = request.getParameter("student_number");
		String gender = request.getParameter("gender");
		String major = request.getParameter("major");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		User u = new User();
		try {
			int age = Integer.valueOf(request.getParameter("age"));
			u.setName(name);
			u.setGender(gender);
			u.setAge(age);
			u.setEmail(email);
			u.setMajor(major);
			u.setPhone(phone);
			u.setStudent_number(student_number);
			if(ud.update(u)) {
				session.commit();
				out.print("<script>alert('更新成功！');window.location.href='studentIndex.jsp';</script>");
			}else {
				out.print("<script>alert('更新失败！');window.location.href='studentInfo.jsp';</script>");
			}
		} catch (NumberFormatException e) {
			out.print("<script>alert('年龄输入有误！');window.location.href='studentInfo.jsp';</script>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
