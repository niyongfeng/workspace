package com.nyf.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.nyf.dao.TeacherProjectDao;
import com.nyf.projo.TeacherProject;
import com.nyf.util.MybatisSessionFactory;

/**
 * Servlet implementation class manUpdateTeacherProject
 */
@WebServlet("/manUpdateTeacherProject")
public class manUpdateTeacherProject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public manUpdateTeacherProject() {
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
		TeacherProjectDao cd = session.getMapper(TeacherProjectDao.class);
		int id = Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String teacher = request.getParameter("teacher");
		int status = Integer.valueOf(request.getParameter("status"));
		try {
			int number = Integer.valueOf(request.getParameter("number"));
			TeacherProject tp = new TeacherProject();
			tp.setId(id);
			tp.setName(name);
			tp.setDescription(description);
			tp.setTeacher(teacher);
			tp.setNumber(number);
			tp.setRelease_time(new Date());
			tp.setStatus(status);
			cd.update(tp);
			session.commit();
			out.print("<script>alert('更新成功！');window.location.href='manTeacherProject.jsp';</script>");
		} catch (NumberFormatException e) {
			out.print("<script>alert('人数修改失败！');window.location.href='manTeacherProject.jsp';</script>");
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
